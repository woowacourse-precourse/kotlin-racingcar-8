package racingcar.validator

import racingcar.Messages

object Validator {
    private const val MAX_NAME_LENGTH = 5

    fun validateTries(tries: String): Int {
        require(tries.toIntOrNull() != null) { Messages.NOT_INTEGER }

        val triesInt = tries.toInt()
        require(triesInt > 0) { Messages.NOT_SMALLER_THAN_ZERO }

        return triesInt
    }

    fun validateCarNames(carNames: List<String>) {
        carNames.forEach {
            require(it.isNotEmpty()) { Messages.NOT_EMPTY_NAME }
        }
        carNames.forEach {
            require(it.length <= MAX_NAME_LENGTH) { Messages.NOT_BIGGER_THAN_FIVE }
        }
    }
}
