package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView
import racingcar.view.OutputView

data class Car(
    val carName: String,
    val position: Int = 0
) {
    fun move (randomValue: Int): Car{
        return if(randomValue >= 4) copy(position = position + 1) else this
    }
}

fun racing(carList: List<Car>, repeatNum: Int): List<Car> {
    var currentCars = carList
    repeat(repeatNum) {
        currentCars = raceOnce(currentCars)
        OutputView.printRaceProcess(currentCars)
    }
    val maxDistance = currentCars.maxByOrNull { it.position }?.position ?: 0
    return currentCars.filter { it.position == maxDistance }
}

fun raceOnce(cars: List<Car>): List<Car> {
    return cars.map { it. move(Randoms.pickNumberInRange(0, 9))}
}


fun validateCarNames(carNames: List<String>): Unit {
    require(carNames.isNotEmpty()) {"최소 한 대 이상의 자동차 이름이 필요합니다."}
    carNames.forEach {
        require(it.isNotBlank()) {"자동차 이름은 빈 문자열일 수 없습니다."}
        require(it.length <= 5) {"자동차 이름은 5글자를 초과할 수 없습니다."}
    }
}
fun validateRepeatNum(repeatNum: String) {
    require(repeatNum.isNotEmpty()) {"시도 횟수는 빈 문자열일 수 없습니다."}
    val number = repeatNum.toIntOrNull()?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
    require(number > 0) {"시도 횟수는 1 이상의 정수여야 합니다."}
}

fun main() {
    OutputView.printCarInputInstruction()
    val carNamesList = InputView.readCarNames()
    validateCarNames(carNamesList)

    OutputView.printRepeatNumInputInstruction()
    val repeatNumInput = InputView.readRepeatNum()
    validateRepeatNum(repeatNumInput)
    val repeatNum = repeatNumInput.toInt()

    val cars = carNamesList.map { carName -> Car(carName) }

    OutputView.printResultHeader()
    val winnerList = racing(cars, repeatNum)
    OutputView.printRaceWinners(winnerList)
}

