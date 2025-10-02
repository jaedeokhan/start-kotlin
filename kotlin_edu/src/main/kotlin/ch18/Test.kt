package org.example.ch18

open class Super {
    fun superFun() {}
}

class Outer {
    val data1: Int = 10

    private val obj = object {
        val data2: Int = 20
        fun some2() {
            // outer 멤버 접근 가능하다.
            println("$data1")
        }
    }

    fun some1() {
        // object {}는 클래스 객체지만, 클래스명이 없어서 Any 타입으로 유추된다.
        // Any라는 클래스에는 data2, some2() 멤버가 없다.
        // obj의 접근 제한자를 private로 주면 된다. why?
        // 컴팡일러 기법으로 object 멤버 접근 가능하게 코드를 바꾼다.
        println("${obj.data2}")
        obj.some2()
    }

    // 이름은 없지만, Super를 상속받은 클래스를 선언, 선언과 동시에 객체 생성
    val obj2 = object: Super() {
        fun subFun() {

        }
    }

    fun some2() {
        // 익명 클래스지만 상위 크랠스 혹은 인터페이스 구현했다면, 상위 타입과 인터페이스 타입으로 이용
        obj2.superFun()
    }

    // singleton 클래스 만들 때 주로 사용
    object MyObject {
        fun some3() {}
    }

    fun some3() {
        MyObject.some3()
    }

    companion object AAA {
        val companionData = 10
        fun companionFun() {}
    }
}

fun main() {
//    println(Outer.data1) // object 멤버는 객체 생성하고 객체로 접근이 가능하다.
    Outer.AAA.companionData
    Outer.AAA.companionFun()

    Outer.companionData
    Outer.companionFun()
}