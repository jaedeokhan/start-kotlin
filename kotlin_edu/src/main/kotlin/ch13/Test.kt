package org.example.ch13

class User {
    // field는 accessor 내에서의 예약어
    var id: Int = 0
        // 하단 get, set은 기본
//        get() {
//            return field
//        }
//        set(value) { field = value}
        set(value) {
            if (value < 0) field = 0
            else field = value
        }

    var name: String? = null
        get() {return field?.uppercase()}

    // property -> 자바 변형 시 private 변수, public getter/setter 함수가 만들어져서 에러 발생
//    val data1: String = "hello"
//        get() = "kim"

    // custom accessor를 추가하면서 field 예약어를 사용하지 않았다면
    // 자바 변형 시 private 변수가 만들어지지 않고 getter/setter만 만들어진다.
    val data1: String // = "hello"
        get() = "kim"

    // var은 get/set이다. get()만 customizing이고 set()은 기본이 적용된다.
    // set() 내에 field가 있다.
    var data2: String = "hello"
        get() = "kim"

}

// 초기화 미루기
lateinit var data3: String

class MyClass {
    val data1: Int
    val data2: String

    init {
        println("in init")
        data1 = 10
        data2 = "hello"
    }

    lateinit var data3: String
    val data4: Int by lazy {
        println("in by lazy")
        10
    }
}


fun main() {
    val obj = User()
    obj.name = "kim"
    obj.id = -1
    println("${obj.name}, ${obj.id}")

    println()

    var obj2 = MyClass()
    println("before")
    println(obj2.data4)
    println("after")
    println(obj2.data4)
    println(obj2.data4)
}
