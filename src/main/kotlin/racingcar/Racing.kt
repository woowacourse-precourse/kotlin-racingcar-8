package racingcar

import camp.nextstep.edu.missionutils.Randoms

data class Racing(private val log: List<Round>) : Iterable<Round> {
    override fun iterator(): Iterator<Round> = log.iterator()
    fun totalRounds(): Int = log.size
    fun getWinners(): List<Car> {
        return last().getWinners()
    }

    companion object {
        private const val MAX_RANDOM_VALUE = 9
        private const val MIN_RANDOM_VALUE = 0
        fun start(startRound: Round, attempt: Attempt = Attempt(0)): Racing {
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
                Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE)
            }
        }
    }
}