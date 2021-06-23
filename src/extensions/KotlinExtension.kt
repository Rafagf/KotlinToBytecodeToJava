package extensions

data class Number(
    val aInt: Int
)

fun Number.toSquare() = aInt * aInt
