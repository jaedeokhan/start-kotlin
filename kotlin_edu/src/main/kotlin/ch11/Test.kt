package org.example.ch11

fun main() {

    class User2 {
        init {
            println("init")
        }
        constructor(){
            println("constructor")
        }
    }

    User2()

    class User3 {
        // 보조 생성자의 매개변수는 생성자의 지역 변수이다.
//        constructor(val name: String, val age: Int) {
//            println("$name, $age")
//        }
//        init {
//            println("init : $name, $age")
//        }
//        fun sayHello() {
//            println("sayHello : $name, $age")
//        }
    }
}