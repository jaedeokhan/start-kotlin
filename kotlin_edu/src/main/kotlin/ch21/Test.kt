package org.example.ch21

fun some1(fun1: (Int, Int) -> Int, fun2: (Int) -> Int): Int {
    val result1 = fun1(10, 20)
    val result2 = fun2(result1)
    println("som1")
    return result2
}

// inline
inline fun some2(fun1: (Int, Int) -> Int, fun2: (Int) -> Int): Int {
    val result1 = fun1(10, 20)
    val result2 = fun2(result1)
    println("som2")
    return result2
}

// 람다함수의 리턴
// local return - 람다함수가 종료
// non local return - 람다함수가 선언된 상위 함수 종료
// label만 붙이면 local return은 가능
fun localReturnTestFun() {
    some1({arg1, arg2 -> arg1 * arg2}) {result ->
        if (result < 0) return@some1 0
        else return@some1 result
    }
    println("test1")

    // inline으로 선언된 함수 호출하면서 람다에서 return을 사용했다.
    some2({arg1, arg2 -> arg1 * arg2}) {result ->
        if (result < 0) return@some2 0
        else return@some2 result
    }
    println("test2")
}

// non local return - 상위 함수 종료
fun nonLocalReturnTestFun(): Int {
    // 일반함수를 호출하는 람다에서 non local return은 허용하지 않음
//    some1({arg1, arg2 -> arg1 * arg2}) {result ->
//        if (result < 0) return 0
//        else return result
//    }
//    println("test1")

    // inline 함수에 전달되면 non local return도 가능
    some2({arg1, arg2 -> arg1 * arg2}) {result ->
        if (result < 0) return 0
        else return result
    }
    println("test2")

    return 0
}

fun main() {
    localReturnTestFun()
}