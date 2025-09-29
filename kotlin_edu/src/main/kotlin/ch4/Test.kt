package org.example.ch4

fun main() {
    // single expression fun
    fun some1(a: Int, b: Int): Int {
        return a + b
    }
    fun some2(a: Int, b: Int) = a + b // 리턴 타입은 자동으로 Int

    // optional, named argument
    // 매개변수에 기본값이 선언되어 있다면 옵셔널이다.
    fun sayHello(name: String = "Kim", no: Int) {
        println("Hello $name, $no")
    }

    sayHello("Han", 1)
    sayHello(name = "Go", no = 2)
    sayHello(no = 3)
}