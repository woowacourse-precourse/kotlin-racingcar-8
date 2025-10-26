package racingcar

class RacingGameController{

    fun start() {
        val carNamesInput = InputView.readCarNames()
        val tryCountInput = InputView.readTryCount()

        val carNames = Validator.validateCarNames(carNamesInput)
        val tryCount = Validator.validateTryCount(tryCountInput)

        val cars = createCars(carNames)

        OutputView.printRaceStartHeader()
        runRace(cars, tryCount)

        val winners = findWinners(cars)
        OutputView.printFinalWinners(winners)
    }

    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { name -> Car(name) }
    }

    private fun runRace(cars: List<Car>, tryCount: Int) {
        repeat(tryCount) {
            moveAllCars(cars)
            OutputView.printCurrentRoundResult(cars)
        }
    }

    private fun moveAllCars(cars: List<Car>) {
        cars.forEach { car ->
            val randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9)
            car.moveForward(randomNumber)
        }
    }

    private fun findWinners(cars: List<Car>): List<String>
    {
        var maxPosition = cars.maxOfOrNull { it.position }
        if (maxPosition == null) {
            maxPosition = 0;
        }

        return cars
            .filter { car -> car.position == maxPosition }
            .map { car -> car.name }
    }
}