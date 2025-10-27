package racingcar.model

class FixedNumberGenerator(private val fixedNumber: Int) : NumberGenerator {
    override fun generate(): Int {
        return fixedNumber
    }
}