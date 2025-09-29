package org.example.ch5

fun main() {
    // 배열 선언, 동시 값 대입
    val array1 = arrayOf(10, true, "hello")

    array1[0] = 20
    println("array1 : ${array1.size}, ${array1[0]}, ${array1.get(0)}")

    // 타입을 한정 짓고 싶다면... 제너릭으로..
    val array2 = arrayOf<Int>(10, 20, 30)
    println("array2 : ${array2.size}, ${array2[0]}, ${array2.get(0)}")

    val array3 = intArrayOf(10, 20, 30)
    println("array3 : ${array3.size}, ${array3[0]}, ${array3.get(0)}")

    val array4 = Array<Int>(3, {0})
    array4[0] = 10

    val array5 = IntArray(3, {0})

    val list1 = listOf<Int>(10, 20) // immutable
    val list2 = mutableListOf<Int>(10, 20) // mutable
    list2.add(30)
    list2.forEach { println(it) }

    // map
    val map = mapOf<String, String>("one" to "hello", "two" to "world")
    map.forEach { println(it) }

    val map2 = mapOf<Int, String>(Pair(1, "hello"), Pair(2, "world"))
    map2.forEach { println(it) }
}