package racingcar

fun main() {
    val names = readln().split(",")
    var cars = mutableMapOf<String, Int>()
    for (name in names) {
        if (name.length >= 5) throw IllegalArgumentException()
        cars[name] = 0
    }
}
