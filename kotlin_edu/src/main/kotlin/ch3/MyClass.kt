package org.example.ch3

import kotlin.random.Random

// top level, class member 변수는 선언과 동시에 초기화 필요, default 초기화 지원 x
val data1: Int = 0
var data2: Int = 0

class MyClass {

    val data3: Int = 0
    var data4: Int = 0

    fun someFun() {
        // local variable은 선언과 동시에 초기화 하지 않아도 된다.
        val data5: Int
        var data6: Int

        data5 = 10
        data6 = 20

        // 변수를 이용하기 전에 초기화 하지 않으면 컴파일 에러가 난다.
        var result = data5 + data6
    }
}

val valData: Int
    get() {
        return Random.nextInt(0, 100)
    }

const val myConst = 10

class MyClass2 {
//    const val myConst3 = 10; // 상수 불가능, 불필요한 인스턴스 상수 불가능

    object A {
        const val myConst4 = 10 // object 클래스 내부에서는 한 번만 생성되기에 상수 가능
    }
}

fun main() {
    println(valData)

    // casting - 대입 할당은 type mismatch
    val a1 = 10
//    val a2: Double = a1
    val a2: Double = a1.toDouble()
    val a3: Int = a2.toInt()

    val a4: String = a3.toString()
    val a5: Int = a4.toInt()

    // String
    val str1 = "Hello \n World"
    val str2 = """
        Hello
        World
    """.trimIndent()
}