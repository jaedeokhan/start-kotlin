package org.example.ch8

var data1: String = "hello" // String + Non null
var data2: String? = "hello" // String + null

fun main() {
//    data1 = null
    data2 = null

    // 캐스팅 - nullable이 non-null type의 상위 타입
    var data3: String? = data1 // String -> String? 하위 -> 상위, 암시적 캐스팅

    data2 = "hello"
//    var data4: String = data2 // ERROR : String? -> String, 상위 -> 하위, 명시적 캐스팅

    var data4: String = data2 as String // 명시적 캐스팅

    data2 = null

    // nullable -> non-null 캐스팅은 명시적 캐스팅은 맞지만, 실제 null이면 NPE
//    data4 = data2 as String // compile OK, runtime ERROR
    // nullable을 non-null로 캐스팅할 때 NPE 가능성이 있음
    // as? null이 아니면 캐스팅하고 null이면 캐스팅하지 마라
    // null이면 캐스팅을 안하지만, 전체 null이다.
    data4 = data2 as? String ?: ""

    // 멤버접근
    val length = data1.length
//    val length2 = data2.length // nullable 객체의 멤버 접근은 ?. 사용해야한다.
}
