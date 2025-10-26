package racingcar

fun main() {
    val list = InputUtil.readNames().toCars()
    val tries = InputUtil.readTries()
    val racing = Racing(list, tries)
    racing.play()
}
