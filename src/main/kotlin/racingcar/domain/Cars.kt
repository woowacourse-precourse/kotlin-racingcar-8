package racingcar.domain

class Cars(private val cars: List<Car>) {

    fun moveAll(randomNumbers: List<Int>) {
        require(randomNumbers.size == cars.size) {
            "랜덤 숫자의 개수가 자동차 수와 일치해야 합니다."
        }
        cars.forEachIndexed { index, car ->
            car.move(randomNumbers[index])
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun getStatus(): List<String> {
        return cars.map { it.getStatus() }
    }
}
