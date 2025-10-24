package racingcar.view

object OutputView {

    fun displayRoundResult(result: Map<String, Int>) {
        result.forEach { (name, score) ->
            println("$name : ${"-".repeat(score)}")
        }
    }
}