package racingcar.model.domain

import racingcar.common.ErrorMessages
import racingcar.model.repository.NameRule
import racingcar.model.repository.Split

object CarName : Split, NameRule {
    override fun split(carNames: String): List<String> {
        val result = carNames.split(',')
        validate(result)
        return result
    }

    override fun validate(names: List<String>) {
        require(names.all { it.isNotBlank() }) { ErrorMessages.CarName.BLANK }
        require(names.all { it.length <= 5 }) { ErrorMessages.CarName.MORE_THEN_5 }
    }
}