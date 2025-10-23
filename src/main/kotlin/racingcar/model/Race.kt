package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(private val users: List<User>) {

    fun play() {
        users.forEach { user ->
            if (getRandomNum() >= MIN_MOVE_NUMBER) {
                user.move()
            }
        }
    }

    fun getRandomNum(): Int = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER)

    companion object {
        private const val MIN_MOVE_NUMBER = 4

        private const val RANDOM_MIN_NUMBER = 0
        private const val RANDOM_MAX_NUMBER = 9
    }
}