package racingcar.domain

interface NumberGenerator {
    /*
    interface 사용 이유
    - Random수에 대해서 Test 가능
    * */
    fun generateNumber(): Int
}