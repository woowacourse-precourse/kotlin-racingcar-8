package racingcar.model.repository

interface Win {
    fun find(position: List<Int>): List<Int>
    fun join(winnerNumber: List<Int>, carNames: List<String>): String
}