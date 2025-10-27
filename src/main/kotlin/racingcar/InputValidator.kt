package racingcar

object InputValidator {

    fun validateCarNames(input: String): List<String> {
        // 쉼표 기준으로 잘라 공백 제거 후 매핑
        val names = input.split(",").map { it.trim() }

        require(names.all { it.isNotEmpty() && it.length <= 5 }) {
            "자동차 이름은 1자 이상, 5자 이하만 가능합니다."
        }

        return names
    }

    fun validateTryCount(input: String): Int {
        val count = input.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
        require(count > 0) { "시도 횟수는 1회 이상이어야 합니다." }
        return count
    }
}