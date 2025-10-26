package racingcar.model.domain

import racingcar.model.repository.Split

object CarName : Split {
    override fun split(carNames: String): List<String> {
        val result = carNames.split(',')
        return result
    }
}