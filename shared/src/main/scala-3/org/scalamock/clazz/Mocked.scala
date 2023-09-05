// Copyright (c) 2011-2015 ScalaMock Contributors (https://github.com/paulbutcher/ScalaMock/graphs/contributors)
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.

package org.scalamock.clazz

import org.scalamock.context.MockContext
import org.scalamock.util.{Defaultable, MockType}

import scala.annotation.experimental
import scala.quoted.*
import scala.reflect.Selectable

class Mocked[T: Type](
  mockName: Option[Expr[String]]
)(using
  val quotes: Quotes
):
  val utils = Mocked.Utils()
  import utils.quotes.reflect.*
  val parents = List(TypeTree.of[Object], TypeTree.of[Selectable], TypeTree.of[T])
  val tpe = TypeRepr.of[T]
  val methods: List[utils.MockedMethod] = utils.MockedMethods(tpe)
  
  /*report.info(
    s"""
      |${methods.map(_.typ).mkString("\n")}
      |""".stripMargin)*/

  @experimental def instance(mockType: MockType, ctx: Expr[MockContext]): Expr[T & Selectable] =
    val symbol: Symbol = Symbol.newClass(
      parent = Symbol.spliceOwner,
      name = "$anon",
      parents = parents.map(_.tpe),
      decls = classSymbol => methods.flatMap { method =>
        List(
          method.definitionSymbol(classSymbol),
          method.mockFunctionValSymbol(
            classSymbol,
            Symbol.classSymbol(s"org.scalamock.function.${mockType}Function${method.types.length - 1}")
          )
        )
      },
      selfType = None
    )

    val definition: ClassDef =
      ClassDef(
        cls = symbol,
        parents = parents,
        body = methods.flatMap(_.implementation(symbol, mockType, ctx))
      )

    //report.info(definition.show)

    Block(
      List(definition),
      Typed(Apply(Select(New(TypeIdent(symbol)), symbol.primaryConstructor), Nil), TypeTree.of[T with Selectable])
    ).asExprOf[T & Selectable]


object Mocked:
  class Utils(using val quotes: Quotes):
    import quotes.reflect.*

    case class MockedMethod(idx: Int, symbol: Symbol, typ: LambdaType):
      val mockValName = "mock$" + symbol.name + "$" + idx
      val types = (typ.paramTypes :+ typ.resType).map(tpe => TypeTree.ref(tpe.typeSymbol))

      def uniqueName(classSymbol: Symbol): Expr[String] =
        '{
          Predef.augmentString("<%s> %s%s.%s%s")
            .format(
              ${Expr(mockValName)},
              ${Expr(classSymbol.name)},
              ${Expr("")},
              ${Expr(symbol.name)},
              ${Expr(typ.paramTypes.map(_.show).mkString(","))}
            )
        }

      def definitionSymbol(classSymbol: Symbol): Symbol =
        Symbol.newMethod(
          parent = classSymbol,
          name = symbol.name,
          tpe = typ,
          flags = Flags.Override,
          privateWithin = Symbol.noSymbol
        )

      def mockFunctionValSymbol(classSymbol: Symbol, mockFunctionClassSymbol: Symbol): Symbol =
        Symbol.newVal(
          parent = classSymbol,
          name = mockValName,
          tpe = TypeTree.ref(mockFunctionClassSymbol).tpe.appliedTo(types.map(_.tpe)),
          flags = Flags.EmptyFlags,
          privateWithin = Symbol.noSymbol
        )

      def implementation(classSymbol: Symbol, mockType: MockType, ctx: Expr[MockContext]): List[Definition] =
        val valSym = classSymbol.declaredField(mockValName)
        val mockFunctionClassSymbol = valSym.typeRef.classSymbol.get
        val methodSym = classSymbol.declaredMethods(idx)

        val valDef: ValDef = ValDef(
          symbol = valSym,
          rhs = Some {
            val mockFunctionUniqueName = '{ scala.Symbol(${ uniqueName(classSymbol) }) }
            val defaultable = typ.resType.asType match
              case '[r] => '{ scala.compiletime.summonInline[Defaultable[r]] }.asTerm
            Apply(
              Apply(
                TypeApply(
                  Select(
                    New(TypeIdent(mockFunctionClassSymbol)),
                    mockFunctionClassSymbol.primaryConstructor
                  ),
                  types
                ),
                List(ctx.asTerm, mockFunctionUniqueName.asTerm)
              ),
              List(defaultable)
            )
          }
        )

        val defDef = DefDef(
          methodSym,
          { args =>
            Some(
              Apply(
                Select.unique(Ref(valDef.symbol), "apply"),
                args.flatten.collect { case t: Term => t }
              )
            )
          }
        )
        List(valDef, defDef)

    object MockedMethods:
      def find(tpe: TypeRepr, name: String, paramTypes: List[TypeRepr]): String =
        MockedMethods(tpe)
          .collectFirst { case method: MockedMethod
            if method.symbol.name == name &&
               method.typ.paramTypes.zip(paramTypes).forall(_ =:= _) => method.mockValName
          }
          .get

      def apply(tpe: TypeRepr): List[MockedMethod] =
        (tpe.typeSymbol.methodMembers.toSet -- TypeRepr.of[Object].typeSymbol.methodMembers).toList
          .map(sym => sym -> tpe.memberType(sym))
          .zipWithIndex
          .collect { case ((sym: Symbol, t: LambdaType), idx: Int) => MockedMethod(idx, sym, t) }
