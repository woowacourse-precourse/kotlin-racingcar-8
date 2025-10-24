package racingcar
import camp.nextstep.edu.missionutils.Randoms
import racingcar.view.InputView
import racingcar.view.OutputView

private const val MIN_RANDOM_NUMBER = 0
private const val MAX_RANDOM_NUMBER = 9

private const val ERROR_NO_CAR_NAMES = "최소 한 대 이상의 자동차 이름이 필요합니다."
private const val ERROR_BLANK_CAR_NAME = "자동차 이름은 빈 문자열일 수 없습니다."
private const val ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 ${Car.MAX_CAR_NAME_LENGTH}글자를 초과할 수 없습니다."
private const val ERROR_EMPTY_TRIAL_COUNT = "시도 횟수는 빈 문자열일 수 없습니다."
private const val ERROR_TRIAL_COUNT_NOT_A_NUMBER = "시도 횟수는 숫자여야 합니다."
private const val ERROR_TRIAL_COUNT_NOT_POSITIVE = "시도 횟수는 1 이상의 정수여야 합니다."
data class Car(
    val carName: String,
    val position: Int = INITIAL_POSITION
) {
    fun move(randomValue: Int): Car {
        return if (randomValue >= MOVE_FORWARD_THRESHOLD) {
            copy(position = position + MOVE_DISTANCE)
        } else this
    }

    companion object {
        const val MAX_CAR_NAME_LENGTH = 5         // 1. 이름 길이는 Car의 속성 규칙
        const val INITIAL_POSITION = 0            // 2. 초기 위치도 Car의 속성 규칙
        const val MOVE_FORWARD_THRESHOLD = 4      // 3. 전진 조건은 Car의 행동 규칙
        const val MOVE_DISTANCE = 1               // 3. 이동 거리도 Car의 행동 규칙
    }
}
fun racing(carList: List<Car>, repeatNum: Int): List<Car> {
    var currentCars = carList
    repeat(repeatNum) {
        currentCars = raceOnce(currentCars)
        OutputView.printRaceProcess(currentCars)
    }
    val maxDistance = currentCars.maxByOrNull { it.position }?.position ?: Car.INITIAL_POSITION
    return currentCars.filter { it.position == maxDistance }
}

fun raceOnce(cars: List<Car>): List<Car> {
    return cars.map { it. move(Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER))}
}


fun validateCarNames(carNames: List<String>): Unit {
    require(carNames.isNotEmpty()) { ERROR_NO_CAR_NAMES }
    carNames.forEach {
        require(it.isNotBlank()) { ERROR_BLANK_CAR_NAME }
        require(it.length <= Car.MAX_CAR_NAME_LENGTH) { ERROR_CAR_NAME_TOO_LONG }
    }
}
fun validateRepeatNum(repeatNum: String) {
    require(repeatNum.isNotEmpty()) { ERROR_EMPTY_TRIAL_COUNT }
    val number = repeatNum.toIntOrNull()?: throw IllegalArgumentException( ERROR_TRIAL_COUNT_NOT_A_NUMBER )
    require(number > 0) { ERROR_TRIAL_COUNT_NOT_POSITIVE }
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


