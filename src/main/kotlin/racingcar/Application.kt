package racingcar

import camp.nextstep.edu.missionutils.Console

fun main() {
    val carNames = getCarName()
    val rountCount = getRoundCount()

    val cars = carNames.map{ Car(it) }

    runRace(cars, rountCount)
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

fun getRoundCount(): Int {
    println("시도할 이동 횟수는 몇 회인가요?")
    val input = Console.readLine() ?: throw IllegalArgumentException("입력이 없습니다.")
    val count = input.toIntOrNull()

    if (count == null || count <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상의 숫자입니다.")
    }
    return count
}


fun runRace(cars: List<Car>, rounds: Int){
    println("\n실행 결과")
    repeat(rounds){
        runRound(cars)
        println()
    }
}

fun runRound(cars: List<Car>){
    for(car in cars){
        car.move()
        car.printState()
    }
}