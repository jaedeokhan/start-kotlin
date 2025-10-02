package org.example.ch14

// 1. 주 생성자가 있다면, 보조 생성자는 항상 주 생성자를 호출해야한다.
// 2. 하위 객체 생성시에 상위 생성자는 호출 되어야 한다.
open class Super(no: Int) {
    var a = 10
    constructor(no: Int, name: String): this(no) {
        println("Super constructor($no, $name)")
    }
    init {
        println("Super init")
    }
}

class Sub(no: Int): Super(no, "kim") {
    var b = 20
    constructor(no: Int, name: String): this(no) {
        println("Sub constructor($no, $name)")
    }
    init {
        println("Sub init")
    }
}

fun main() {
    val obj = Sub(10, "lee")
    println("${obj.a}, ${obj.b}")

    // 캐스팅
    val obj2: Sub = Sub(10)
    val obj3: Super = obj2 // 하위 -> 상위
    val obj4: Sub = obj3 as Sub // 상위 -> 하위

    val obj5: Sub = Super(10) as Sub // 하위 -> 상위 바로는 실패
}