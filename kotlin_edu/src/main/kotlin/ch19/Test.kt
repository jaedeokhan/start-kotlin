package org.example.ch19

fun main() {
    // List<Int> 데이터를 매개변수로 받아서 데이터를 조건에 맞게 필터링해서 리턴한다.
    // 조건은 10보다 큰 수, 혹은 홀수, 혹은 3의 배수등 다양화

    fun customFilter(list: List<Int>, argFun: (Int) -> Boolean): List<Int> {
        val resultList = mutableListOf<Int>()

        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val no = iterator.next()
            val result = argFun(no)
            if (result) {
                resultList.add(no)
            }
        }
        return resultList
    }

    val testList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13)
    println(testList)

    val resultList = customFilter(testList, {it > 10 || it % 2 != 0 || it % 3 == 0})
    println(resultList)

    // run, let, apply, with
    class User {
        var name: String? = ""
        var age: Int = 0
        fun sayHello() {}
    }

    // 동시에 객체 멤버에 여러번 접근
    val obj = User()
    obj.name = "kim"
    obj.age = 20
    obj.sayHello()

    obj.run {
        name = "lee"
        age = 20
        sayHello()
    }
}
