package racingcar.model

import racingcar.validator.Validator

class UserParser(inputName: String) {
    init {
        val names = inputName.split(',').map { it.trim() }
        Validator.validateNameLengths(names)
    }
}