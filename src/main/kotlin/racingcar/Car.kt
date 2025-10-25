package racingcar

class Car(private val name: String, private var score: Int = 0) {
    companion object {
        const val MAX_NAME_LENGTH = 5
    }

    init {
        require(name.length <= MAX_NAME_LENGTH) { ExceptionMessage.NAME_LENGTH_OVER }
    }

    fun move(randomNumber : Int) {
        if(randomNumber >= 4) score += 1
    }

    fun showCurrentProgress() { println("$name : "+"-".repeat(score)) }
}