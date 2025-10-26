package racingcar.view

object OutputView {

    fun printResult() {
        printEnter()
        println("실행 결과")
    }

    private fun carName(car: String) {
        print("$car : ")
    }

    private fun showCarLocation(location: Int) {
        repeat(location) {
            print("-")
        }
    }

    fun processResult(car: String, location: Int) {
        carName(car)
        showCarLocation(location)
        printEnter()
    }

    fun finalResult(winner: List<String>) {
        println("최종 우승자 : ${winner.joinToString()}")
    }

    fun printEnter() {
        println()
    }
}