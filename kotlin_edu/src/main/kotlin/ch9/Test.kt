package org.example.ch9

fun some(array: Array<Any>) {
    try {
        println("try top")

        val intData: Int = array[0] as Int

        val data: String = array[2] as String
    } catch (e: ClassCastException) {
        println("catch ClassCastException")
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("catch ArrayIndexOutOfBoundsException")
    } finally {
        println("finally")
    }
}

fun main() {
//    some(arrayOf("0", 1, "6")) // cast ex

    some(arrayOf(1, "2"))
}