package racingcar.model.domain

import racingcar.model.repository.Win

object Winner : Win {
    override fun find(position: List<Int>): List<Int> {
        val max = position.maxOrNull() ?: 0
        return position.indices.filter { position[it] == max }
    }

    override fun join(winnerNumber: List<Int>, carNames: List<String>): String =
        winnerNumber.map { carNames[it] }.joinToString(", ")
}