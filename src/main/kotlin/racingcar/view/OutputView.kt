package racingcar.view

object OutputView : Output {

    override fun printResult() {
        println()
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

    override fun processResult(car: String, location: Int) {
        carName(car)
        showCarLocation(location)
        println()
    }

    override fun finalResult(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString()}")
    }
}