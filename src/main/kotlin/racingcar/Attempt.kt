package racingcar

data class Attempt(val value: Int) {
    init {
        require(value >= 0) { "시도 횟수는 음수일 수 없습니다." }
    }
}