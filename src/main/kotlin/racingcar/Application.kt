package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    RacingGame().start()
}

// 자동차의 상태(이름, 위치)를 관리하는 데이터 클래스
data class Car(val name: String, var position: Int = 0)

class RacingGame {
    fun start() {
        val carNames = getCarNames()
        val tryCount = getTryCount()
        val cars = carNames.map { Car(it) } // 이름 목록을 Car 객체 리스트로 변환

        runRace(cars, tryCount)
        printWinners(cars) // 우승자 선정 및 출력 로직 호출
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine() ?: ""
        val names = input.split(",").map { it.trim() }

        validateCarNames(names)
        return names
    }

    private fun validateCarNames(names: List<String>) {
        if (names.any { it.isBlank() }) {
            throw IllegalArgumentException("자동차 이름은 공백이거나 비어있을 수 없습니다.")
        }
        if (names.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
    }

    private fun getTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine() ?: ""
        val count = input.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")

        if (count <= 0) {
            throw IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.")
        }
        return count
    }

    // 경주 실행의 메인 루프
    private fun runRace(cars: List<Car>, tryCount: Int) {
        println("\n실행 결과")
        repeat(tryCount) {
            playRound(cars)
            println() // 각 라운드 실행 후 한 줄 띄움
        }
    }

    // 단일 라운드 실행 (모든 차 이동 시도 및 결과 출력)
    private fun playRound(cars: List<Car>) {
        cars.forEach { car ->
            tryMove(car)
        }
        printRoundResult(cars)
    }

    // 개별 자동차의 이동 시도
    private fun tryMove(car: Car) {
        val randomValue = Randoms.pickNumberInRange(0, 9)
        if (randomValue >= 4) { // 4 이상일 경우 전진
            car.position++
        }
    }

    // 현재 라운드의 결과 출력
    private fun printRoundResult(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    // 최종 우승자 선정 및 출력
    private fun printWinners(cars: List<Car>) {
        // 가장 많이 전진한 위치(maxPosition)를 찾는다.
        val maxPosition = cars.maxOfOrNull { it.position } ?: 0

        // maxPosition과 동일한 위치를 가진 자동차들(우승자)의 이름만 추출한다.
        val winners = cars.filter { it.position == maxPosition }
            .map { it.name }

        // 우승자 목록을 쉼표(,)로 연결하여 출력한다.
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}