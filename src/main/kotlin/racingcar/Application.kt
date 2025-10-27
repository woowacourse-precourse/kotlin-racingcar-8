package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
}

fun getCarName(): List<String>{
    println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분): ")
    val input = Console.readLine() ?: throw IllegalArgumentException("입력이 없습니다.")
    val names = input.split(",")

    val it = names.iterator()

    while(it.hasNext()){
        val str = it.next().trim()
        if (str.isBlank() || str.length > 5 ){
            throw IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하 입니다.")
        }
    }
    return names
}
