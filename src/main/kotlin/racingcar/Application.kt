package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class AttemptingNumber(val value: Int) {
    init {
        require(value >= 0) { "시도 횟수는 음수일 수 없습니다." }
    }
}

data class Car(val name: String, val position: Int) {
    init {
        require(name.isNotEmpty()) { "자동차 이름은 한 글자 이상을 포함해야 합니다." }
        require(name.length <= NAME_LENGTH_LIMIT) { "자동차 이름은 5글자 이하여야 합니다." }
    }

    init {
        require(position >= START_POSITION) {
            "자동차의 위치($position)는 $START_POSITION 미만일 수 없습니다."
        }
    }

    fun moveForward(): Car = Car(name, position + MOVE_INCREMENT)

    fun tryMoveForward(number: Int): Car {
        if (number >= MOVING_THRESHOLD) {
            return moveForward()
        }
        return this
    }

    fun status(): String {
        val path: String = "-".repeat(position)
        return "$name : $path"
    }

    companion object {
        const val START_POSITION = 0
        const val NAME_LENGTH_LIMIT = 5
        const val MOVE_INCREMENT = 1
        const val MOVING_THRESHOLD = 4

        fun withStartPosition(name: String): Car = Car(name, START_POSITION)
    }
}

data class Round(val time: Int, val cars: List<Car>) {
    fun tryMoveForward(numbers: List<Int>): Round {
        require(numbers.size == cars.size) { "숫자 수와 자동차 수가 동일해야합니다." }
        return Round(time + 1, cars.zip(numbers).map { (car, number) ->
            car.tryMoveForward(number)
        })
    }

    private fun getMaxPosition() = (cars.maxBy { it.position }).position
    fun getWinners(): List<Car> = cars.filter { getMaxPosition() == it.position }

    fun showStatus() {
        for (car in cars) {
            println(car.status())
        }
    }

    fun totalCars(): Int = cars.size

    companion object {
        fun startWith(names: List<String>): Round {
            val usedNames = mutableSetOf<String>()
            return Round(0, names.map { name ->
                require(!usedNames.contains(name)) { "중복된 자동차 이름($name)은 허용되지 않습니다." }
                usedNames.add(name)
                Car.withStartPosition(name)
            })
        }
    }
}

data class Racing(private val log: List<Round>) : Iterable<Round> {
    override fun iterator(): Iterator<Round> = log.iterator()
    fun totalRounds(): Int = log.size

    companion object {
        fun with(startRound: Round, attempt: AttemptingNumber = AttemptingNumber(0)): Racing {
            val log = mutableListOf(startRound)
            for (current in 1..attempt.value) {
                val past = log[current - 1]
                val movingCondition = generateRandomList(startRound.totalCars())
                log.add(past.tryMoveForward(movingCondition))
            }
            return Racing(log)
        }

        private fun generateRandomList(size: Int): List<Int> {
            return (1..size).map {
                Randoms.pickNumberInRange(0, 9)
            }
        }
    }
}

fun main() {
    val cars = Round.startWith(listOf("pobi", "woni", "jun"))
    val racing = Racing.with(cars, attempt = AttemptingNumber(3))
    for (round in racing) {
        round.showStatus()
    }
}
