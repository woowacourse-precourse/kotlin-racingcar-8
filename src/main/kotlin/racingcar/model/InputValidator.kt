package racingcar.model

object InputValidator {

    private const val MIN_NAME_LENGTH = 1
    private const val MAX_NAME_LENGTH = 5

    fun validateCarName(carNames: List<String>) {
        carNames.forEach { name ->
            require(name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH)
            { "각 자동차의 이름의 길이는 1~5자 이어야 합니다." }
        }
    }

    fun findDuplicateName(carNames: List<String>): Map<String, Set<Int>> {
        val duplicateNameIndexes = mutableMapOf<String, MutableSet<Int>>()
        carNames.forEachIndexed { index, value ->
            duplicateNameIndexes.computeIfAbsent(value) { mutableSetOf() }.add(index)
        }
        return duplicateNameIndexes.filterValues { it.size > 1 }
    }

    fun validateRaceCount(raceCount: String) {
        val count = raceCount.toIntOrNull()
        require(count != null) { "경주를 시도할 횟수는 숫자만 입력해주세요." }
        require(count > 0) { "경주를 시도할 횟수는 1 이상이어야 합니다." }
    }
}