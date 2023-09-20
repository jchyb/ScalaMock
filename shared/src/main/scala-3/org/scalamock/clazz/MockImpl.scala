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

import org.scalamock.function.*
import org.scalamock.context.MockContext

import scala.quoted.*
import org.scalamock.util.{Defaultable, MockType}
import MockFunctionFinder.findMockFunction

import scala.annotation.experimental
import scala.reflect.Selectable

@experimental
object MockImpl:

  def mock[T: Type](mockContext: Expr[MockContext])(using quotes: Quotes): Expr[T & Selectable] =
    Mocked[T](mockName = None).instance(MockType.Mock, mockContext)

  def stub[T: Type](mockContext: Expr[MockContext])(using quotes: Quotes): Expr[T & Selectable] =
    Mocked[T](mockName = None).instance(MockType.Stub, mockContext)

  def mockWithName[T: Type](mockName: Expr[String])(mockContext: Expr[MockContext])(using quotes: Quotes): Expr[T & Selectable] =
    Mocked[T](mockName = Some(mockName)).instance(MockType.Mock, mockContext)

  def stubWithName[T: Type](mockName: Expr[String])(mockContext: Expr[MockContext])(using quotes: Quotes): Expr[T & Selectable] =
    Mocked[T](mockName = Some(mockName)).instance(MockType.Stub, mockContext)


  def toMockFunction0[R: Type](f: Expr[() => R])(evidence$1: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[() => R, MockFunction0[R]](f, List())

  def toMockFunction1[T1: Type, R: Type](f: Expr[T1 => R])(evidence$2: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[T1 => R, MockFunction1[T1, R]](f, List(TypeRepr.of[T1]))

  def toMockFunction2[T1: Type, T2: Type, R: Type](f: Expr[(T1, T2) => R])(evidence$3: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2) => R, MockFunction2[T1, T2, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2]))

  def toMockFunction3[T1: Type, T2: Type, T3: Type, R: Type](f: Expr[(T1, T2, T3) => R])(evidence$4: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3) => R, MockFunction3[T1, T2, T3, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3]))

  def toMockFunction4[T1: Type, T2: Type, T3: Type, T4: Type, R: Type](f: Expr[(T1, T2, T3, T4) => R])(evidence$5: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4) => R, MockFunction4[T1, T2, T3, T4, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4]))

  def toMockFunction5[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5) => R])(evidence$6: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5) => R, MockFunction5[T1, T2, T3, T4, T5, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5]))

  def toMockFunction6[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6) => R])(evidence$7: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6) => R, MockFunction6[T1, T2, T3, T4, T5, T6, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6]))

  def toMockFunction7[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7) => R])(evidence$8: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7) => R, MockFunction7[T1, T2, T3, T4, T5, T6, T7, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7]))

  def toMockFunction8[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8) => R])(evidence$9: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8) => R, MockFunction8[T1, T2, T3, T4, T5, T6, T7, T8, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8]))

  def toMockFunction9[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9) => R])(evidence$10: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9) => R, MockFunction9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9]))

  def toMockFunction10[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R])(evidence$10: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R, MockFunction10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10]))

  def toMockFunction11[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R])(evidence$11: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R, MockFunction11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11]))

  def toMockFunction12[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R])(evidence$12: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R, MockFunction12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12]))

  def toMockFunction13[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R])(evidence$13: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R, MockFunction13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13]))

  def toMockFunction14[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R])(evidence$14: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R, MockFunction14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14]))

  def toMockFunction15[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R])(evidence$15: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R, MockFunction15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15]))

  def toMockFunction16[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R])(evidence$16: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R, MockFunction16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16]))

  def toMockFunction17[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R])(evidence$17: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R, MockFunction17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17]))

  def toMockFunction18[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R])(evidence$18: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R, MockFunction18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18]))

  def toMockFunction19[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R])(evidence$19: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R, MockFunction19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19]))

  def toMockFunction20[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, T20: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R])(evidence$20: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R, MockFunction20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19], TypeRepr.of[T20]))

  def toMockFunction21[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, T20: Type, T21: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R])(evidence$21: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R, MockFunction21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19], TypeRepr.of[T20], TypeRepr.of[T21]))

  def toMockFunction22[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, T20: Type, T21: Type, T22: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R])(evidence$22: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R, MockFunction22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19], TypeRepr.of[T20], TypeRepr.of[T21], TypeRepr.of[T22]))

  def toStubFunction0[R: Type](f: Expr[() => R])(evidence$20: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[() => R, StubFunction0[R]](f, List())

  def toStubFunction1[T1: Type, R: Type](f: Expr[T1 => R])(evidence$21: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[T1 => R, StubFunction1[T1, R]](f, List(TypeRepr.of[T1]))

  def toStubFunction2[T1: Type, T2: Type, R: Type](f: Expr[(T1, T2) => R])(evidence$22: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2) => R, StubFunction2[T1, T2, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2]))

  def toStubFunction3[T1: Type, T2: Type, T3: Type, R: Type](f: Expr[(T1, T2, T3) => R])(evidence$23: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3) => R, StubFunction3[T1, T2, T3, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3]))

  def toStubFunction4[T1: Type, T2: Type, T3: Type, T4: Type, R: Type](f: Expr[(T1, T2, T3, T4) => R])(evidence$24: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4) => R, StubFunction4[T1, T2, T3, T4, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4]))

  def toStubFunction5[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5) => R])(evidence$25: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5) => R, StubFunction5[T1, T2, T3, T4, T5, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5]))

  def toStubFunction6[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6) => R])(evidence$26: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6) => R, StubFunction6[T1, T2, T3, T4, T5, T6, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6]))

  def toStubFunction7[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7) => R])(evidence$27: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7) => R, StubFunction7[T1, T2, T3, T4, T5, T6, T7, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7]))

  def toStubFunction8[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8) => R])(evidence$28: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8) => R, StubFunction8[T1, T2, T3, T4, T5, T6, T7, T8, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8]))

  def toStubFunction9[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9) => R])(evidence$29: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9) => R, StubFunction9[T1, T2, T3, T4, T5, T6, T7, T8, T9, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9]))

  def toStubFunction10[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R])(evidence$210: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10) => R, StubFunction10[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10]))

  def toStubFunction11[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R])(evidence$211: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11) => R, StubFunction11[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11]))

  def toStubFunction12[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R])(evidence$212: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12) => R, StubFunction12[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12]))

  def toStubFunction13[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R])(evidence$213: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13) => R, StubFunction13[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13]))

  def toStubFunction14[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R])(evidence$214: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14) => R, StubFunction14[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14]))

  def toStubFunction15[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R])(evidence$215: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15) => R, StubFunction15[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15]))

  def toStubFunction16[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R])(evidence$216: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16) => R, StubFunction16[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16]))

  def toStubFunction17[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R])(evidence$217: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17) => R, StubFunction17[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17]))

  def toStubFunction18[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R])(evidence$218: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18) => R, StubFunction18[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18]))

  def toStubFunction19[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R])(evidence$219: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19) => R, StubFunction19[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19]))

  def toStubFunction20[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, T20: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R])(evidence$220: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20) => R, StubFunction20[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19], TypeRepr.of[T20]))

  def toStubFunction21[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, T20: Type, T21: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R])(evidence$221: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21) => R, StubFunction21[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19], TypeRepr.of[T20], TypeRepr.of[T21]))

  def toStubFunction22[T1: Type, T2: Type, T3: Type, T4: Type, T5: Type, T6: Type, T7: Type, T8: Type, T9: Type, T10: Type, T11: Type, T12: Type, T13: Type, T14: Type, T15: Type, T16: Type, T17: Type, T18: Type, T19: Type, T20: Type, T21: Type, T22: Type, R: Type](f: Expr[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R])(evidence$222: Expr[Defaultable[R]])(using quotes: Quotes) =
    import quotes.reflect.*
    findMockFunction[(T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22) => R, StubFunction22[T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R]](f, List(TypeRepr.of[T1], TypeRepr.of[T2], TypeRepr.of[T3], TypeRepr.of[T4], TypeRepr.of[T5], TypeRepr.of[T6], TypeRepr.of[T7], TypeRepr.of[T8], TypeRepr.of[T9], TypeRepr.of[T10], TypeRepr.of[T11], TypeRepr.of[T12], TypeRepr.of[T13], TypeRepr.of[T14], TypeRepr.of[T15], TypeRepr.of[T16], TypeRepr.of[T17], TypeRepr.of[T18], TypeRepr.of[T19], TypeRepr.of[T20], TypeRepr.of[T21], TypeRepr.of[T22]))

