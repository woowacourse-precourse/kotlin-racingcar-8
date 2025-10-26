package racingcar.model

class FakeRandomNumberGenerator(private val numbers: List<Int>): NumberGenerator {
    private val iterator = numbers.iterator()
    override fun getRandomNumber(): Int {
        return iterator.next()
    }
}