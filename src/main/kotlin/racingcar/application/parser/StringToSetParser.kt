package racingcar.application.parser

import racingcar.domain.error.ErrorCode.CAR_NAMES_MUST_BE_UNIQUE
import racingcar.domain.error.ErrorCode.INVALID_CAR_NAME_LENGTH

private const val MAX_CAR_NAME_LENGTH = 5

class StringToSetParser : Parser<Set<String>> {
    override fun parse(input: String): Set<String> {
        val carNamesArr = input.split(",")
        val carNamesSet = HashSet<String>()
        for (name in carNamesArr) {
            require(name.length <= MAX_CAR_NAME_LENGTH) { INVALID_CAR_NAME_LENGTH }
            require(carNamesSet.add(name)) { CAR_NAMES_MUST_BE_UNIQUE }
        }
        return carNamesSet
    }
}