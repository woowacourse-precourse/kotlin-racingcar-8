package racingcar.view

interface Output {
    fun printResult()
    fun processResult(car: String, location: Int)
    fun finalResult(winners: List<String>)
}