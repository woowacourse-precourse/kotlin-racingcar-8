package racingcar

data class Car(val name: String) {
    init {
        require(name.isNotEmpty()) { "자동차 이름은 한 글자 이상을 포함해야 합니다." }
    }
}

fun main() {
    // TODO: 프로그램 구현
}
