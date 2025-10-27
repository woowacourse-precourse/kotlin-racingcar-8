package racingcar

import java.util.Random

fun main() {
    val names = readln().split(",")
    var cars = mutableMapOf<String, Int>()
    for(name in names){
        if(name.length >= 5) throw IllegalArgumentException()
        cars[name] = 0
    }

    val num = readln().toInt()

    repeat(num) {
        for(name in names) {
            getRandmoNum(name, cars)
        }
    }
    val max = cars.values.maxOrNull()
    val winner = cars.filter { it.value == max }.keys.joinToString(", ")
    println("최종 우승자 : $winner")
}
private fun getRandmoNum(name: String, cars: MutableMap<String, Int>){
    val num = Random().nextInt(10)
    print("$name : ")
    if(num >= 4){
        repeat(num - 3) {
            print("-")
            cars[name] = cars[name]!! + 1
        }
    }
    println()
}
