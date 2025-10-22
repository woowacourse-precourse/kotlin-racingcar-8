package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = Console.readLine()
    val names = parse(input)

    println("시도할 횟수는 몇 회인가요?")
    val numInput = Console.readLine()
    val num = numCheck(numInput)
}

fun parse(input: String): List<String>{
    val names = input.split(",").map { it.trim() }
    if (names.isEmpty()) throw IllegalArgumentException("No name")
    if (names.any { it.isEmpty() }) throw IllegalArgumentException("Empty name")
    if (names.any { it.length > 5 }) throw IllegalArgumentException("Names can be up to 5 characters long.")
    return names
}

fun numCheck(input: String): Int{
    val num = input.toIntOrNull() ?: throw IllegalArgumentException("No number")
    if (num <= 0) throw IllegalArgumentException("No literal number")
    return num
}
