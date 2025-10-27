package racingcar.controller

import racingcar.view.Output

class FakeOutput : Output {
    private val output = mutableListOf<String>()

    fun getOutput(): List<String> = output.toList()

    override fun printResult() {
        output.add("[결과 출력]")
    }

    override fun processResult(car: String, location: Int) {
        output.add("$car : ${"-".repeat(location)}")
    }

    override fun finalResult(winners: List<String>) {
        output.add("최종 우승자 : ${winners.joinToString()}")
    }


}