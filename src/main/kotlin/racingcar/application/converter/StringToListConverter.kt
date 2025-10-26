package racingcar.application.converter

import racingcar.domain.error.ErrorCode.INVALID_CAR_NAME_LENGTH

private const val MAX_CAR_NAME_LENGTH = 4

class StringToListConverter : Converter<List<String>> {
    override fun convert(input: String): List<String> {
        val carNamesArr = input.split(",")
        for (name in carNamesArr) {
            require(name.length <= MAX_CAR_NAME_LENGTH) { INVALID_CAR_NAME_LENGTH }
        }
        return carNamesArr
    }
}