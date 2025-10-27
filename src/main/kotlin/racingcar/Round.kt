package racingcar

data class Round(val cars: List<Car>) : Iterable<Car> {
    override fun iterator(): Iterator<Car> = cars.iterator()
    fun tryMoveForward(numbers: List<Int>): Round {
        require(numbers.size == cars.size) { "숫자 수와 자동차 수가 동일해야합니다." }
        return Round(cars.zip(numbers).map { (car, number) ->
            car.tryMoveForward(number)
        })
    }

    private fun getMaxPosition() = (cars.maxBy { it.position }).position
    fun getWinners(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { maxPosition == it.position }
    }

    fun totalCars(): Int = cars.size

    companion object {
        fun startWith(names: List<String>): Round {
            val usedNames = mutableSetOf<String>()
            return Round(names.map { name ->
                require(!usedNames.contains(name)) { "중복된 자동차 이름($name)은 허용되지 않습니다." }
                usedNames.add(name)
                Car.withStartPosition(name)
            })
        }
    }
}