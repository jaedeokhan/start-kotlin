package org.example.ch17

class User(val no: Int, val name: String)

data class UserData(val no: Int, val name: String) {
    var email: String? = null
    constructor(no: Int, name: String, email: String): this(no, name) {
        this.email = email
    }
}

fun main() {
    val user1 = User(1, "kim")
    val user2 = User(1, "kim")
    val user3 = UserData(1, "kim")
    val user4 = UserData(1, "kim")

    println("${user1 == user2}, ${user3 == user4}, ${user3 == user1}")

    val user5 = UserData(1, "kim", "test")
    val user6 = UserData(1, "kim", "test")
    println("${user5 == user6}, ${user5 == user3}")

    data class Data1(val data1: Int, val data2: Int, val data3: Int)
    fun some(): Data1 {
        return Data1(1, 2, 3)
    }

    val (e1, e2, e3) = some()
    println("${e1} - ${e2} - ${e3}")
}
