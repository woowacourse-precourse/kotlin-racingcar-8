package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class Race(private val users: List<User>) {

    fun play() {
        users.forEach { user ->
            if (getRandomNum() >= 4) {
                user.score++
            }
        }
    }

    fun getRandomNum(): Int = Randoms.pickNumberInRange(0, 9)
}