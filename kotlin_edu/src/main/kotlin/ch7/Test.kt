package org.example.ch7

fun main() {
    val array1 = arrayOf(1,2,3)
    val array2 = arrayOf(10,20,30)
    val array3 = arrayOf(*array1, *array2)

    array3.forEach { print("$it ") }

    println()

    // 연산자 재정의
    // 숫자 값을 유지하는 클래스, 값의 더하기 연산을 알고리즘대로 동작하게 하고 싶음
    class MyClass(val no: Int) {
        operator fun plus(arg: Int): Int {
            return no - arg
        }
    }

    // 연산자 재정의는 객체의 멤버 함수 - extension 함수
    operator fun MyClass.minus(arg: Int): Int {
        return no + arg
    }

    val obj = MyClass(10)
    val result1 = obj + 5
    val result2 = obj - 10

    println("result1 : $result1")
    println("result2 : $result2")
}

