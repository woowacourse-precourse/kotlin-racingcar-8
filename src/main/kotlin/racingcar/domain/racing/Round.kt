package racingcar.domain.racing

import racingcar.domain.car.Name

class Round(
    private val _roundResult: MutableList<String> = mutableListOf(),
) {
    val roundResult: String get() = _roundResult.joinToString("\n")

    fun saveRoundResult(name: Name, distance: Int) {
        val result = "${name.value} : ${"-".repeat(distance)}"
        _roundResult.add(result)
    }
}