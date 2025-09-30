package org.example.ch12


// 주 생성자가 선언이 되었다면, 보조생성자로 객체 생성 시점에 주 생성자는 호출되어야 한다.
class User(name: String) {
    init {
        println("init")
    }
    constructor(name: String, age: Int): this(name) {
        println("constructor(name: String, age: Int)")
    }
    constructor(name: String, age: Int, email: String): this(name, age) {
        println("constructor(name: String, age: Int, email: String)")
    }
}

fun main() {
    User("kim", 20, "a@a.com")
}