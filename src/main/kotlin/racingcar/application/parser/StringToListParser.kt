package racingcar.application.parser

import racingcar.domain.error.ErrorCode.INVALID_CAR_NAME_LENGTH

private const val MAX_CAR_NAME_LENGTH = 5

class StringToListParser : Parser<List<String>> {
    override fun parse(input: String): List<String> {
        val carNamesArr = input.split(",")
        for (name in carNamesArr) {
            require(name.length <= MAX_CAR_NAME_LENGTH) { INVALID_CAR_NAME_LENGTH }
        }
        return carNamesArr
    }
}