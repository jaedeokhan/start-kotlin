package org.example.ch6

fun main() {
    // if
    val a = 5

    // when
    when (a) {
        in 1..10 -> println("1..10")
        in 11..20 -> println("11..20")
    }

    // 집합데이터에 있는 데이터라면
    val list = listOf<Int>(1,2,3,4)
    when (a) {
        in list -> println("in list")
        else -> println("not in list")
    }

    val result4 = when(a) {
        1 -> "hello"
        2 -> "world"
        else -> "none"
    }

    // for
    for (i in 1..5) {
        print("$i ")
    }

    println()

    for (i in 1 until 5) {
        print("$i ")
    }

    println()

    for (i in 1 .. 10 step 2) {
        print("$i ")
    }

    println()

    for (i in 10 downTo 1 step 2) {
        print("$i ")
    }

    println()

    val array = arrayOf("one", "two", "three")

    for (value in array) {
        print("$value ")
    }

    println()

    for (index in array.indices) {
        print("$index ")
    }

    println()

    for ((index, value) in array.withIndex()) {
        print("$index - $value ")
    }
}