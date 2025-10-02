package org.example.ch15

open class Shape {
    open fun print() {
        print("Shape print")
    }
}

class Circle: Shape() {
    override fun print() {
        println("Circle print")
    }
}

class Rect: Shape() {
    override fun print() {
        println("Rect print")
    }
}

fun drawScreen(shapes: Array<Shape>) {
    shapes.forEach { shape ->
        shape.print()
    }
}

fun main() {
    val array = arrayOf<Shape>(Circle(), Rect())
    drawScreen(array)
}