package collections

//infix

infix fun Int.increment(x: Int): Int { return x + 1 }

val four = 3 increment 1


//operator

class Point(val x: Int, val y: Int)

operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

fun main() {
    println(-point)  // prints "Point(x=-10, y=-20)"
}

//typealias
typealias Rafa = (Int) -> String

//lateinit

class Foo(val a: Int) {

    lateinit var b: String
}

