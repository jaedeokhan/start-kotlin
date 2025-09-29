// kt 파일이 있는 위치와 관련없는 가상 패키지 선언 가능하다.
package ch1

import java.util.Date

// top - level에 변수, 함수 선언이 가능하다.
var sum = 0

fun calSum() {
    for(i in 1 .. 10) {
        sum += 1
    }
}

class User {
    val name = "kim"
    fun sayHello() {
        val date = Date();
        println("date : $date")
    }
}

fun main() {
    calSum()
    println(sum)
    User().sayHello()
}