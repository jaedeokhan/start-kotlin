package org.example.ch10

fun main() {

    // 클래스 선언 - 주생성자 선언
    class MyClass() {}
    class MyClass2 {}
    class MyClass3 constructor() {}

    class User1(name: String, age: Int = 0)
    User1("kim", 20)
    User1("kim")
    User1(age = 20, name = "kim")

    // 주 생성자로 객체 생성 시점에 실행 필요 시 init
    class User2(name: String) {
        init {
            println("init - $name")
        }
    }

    User2("han")

    class User3(name: String, age: Int) {
        var name: String = ""
        var age: Int = 0
        init {
            this.name = name
            this.age = age
        }
        fun sayHello() {
            println("$name, $age")
        }
    }

    User3("kim", 20).sayHello()

    // 위 코드를 코틀린 스타일로 변경
    // 주 생성자의 매개변수에 한해서 var, val 추가 가능하고 추가하면 즉시 멤버 변수가 된다.
    class User4(val name: String, val age: Int) {
        fun sayHello() {
            println("$name, $age")
        }
    }

    User4("han", 100).sayHello()
}