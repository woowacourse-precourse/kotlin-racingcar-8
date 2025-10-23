package racingcar.model

import racingcar.constant.DELIMITER
import racingcar.validator.Validator

class UserParser(inputName: String) {
    private val userNames: List<String>

    init {
        val names = inputName.split(DELIMITER).map { it.trim() }
        Validator.validateNameLengths(names)

        userNames = names
    }
}