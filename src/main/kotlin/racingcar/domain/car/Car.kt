package racingcar.domain.car

data class Car(val name: Name, val distance: Int = 0) {

    fun getResult(): String {
        return "${name.value} : ${"-".repeat(distance)}"
    }
}