package racingcar.domain.car

data class Cars(private val _cars: MutableList<Car>) {
    val cars: List<Car> get() = _cars

    fun sortByDistanceDesc() {
        _cars.sortByDescending { it.distance }
    }
}