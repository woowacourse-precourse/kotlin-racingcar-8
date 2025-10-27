package racingcar

object AttemptCountParser {

    fun parse(input: String): Int {
        val number = toIntOrThrow(input)
        validateNonNegative(number)
        return number
    }

    private fun toIntOrThrow(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("시도 횟수는 숫자여야 합니다.")
    }

    private fun validateNonNegative(number: Int) {
        if (number < 0) {
            throw IllegalArgumentException("시도 횟수는 음수가 될 수 없습니다.")
        }
        // number == 0 은 허용. 이 경우 라운드 실행 없이 우승자만 출력될 수 있음.
    }
}
