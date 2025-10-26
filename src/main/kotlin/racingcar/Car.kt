package racingcar

class Car(private val name: String, private var score: Int = 0) {
    companion object {
        const val MAX_NAME_LENGTH = 5
        const val CAN_MOVE_MIN_NUMBER = 4
    }

    init {
        require(name.length <= MAX_NAME_LENGTH) { ExceptionMessage.NAME_LENGTH_OVER }
    }

    fun move(randomNumber : Int) {
        if(randomNumber >= CAN_MOVE_MIN_NUMBER) score += 1
    }

    fun showCurrentProgress() { println("$name : "+"-".repeat(score)) }

    fun getScore() : Int { return score }

    fun getName() : String { return name }
}