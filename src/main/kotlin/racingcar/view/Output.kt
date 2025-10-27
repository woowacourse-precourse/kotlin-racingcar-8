package racingcar.view

class Output {
    fun startPrintResult(){
        println("실행 결과")
    }

    fun printGamesResult(results: Map<String, String>) {
        results.forEach { (name, currentDistance) ->
            println("$name : $currentDistance")
        }
        println()
    }

    fun finalWinners(winners: String) {
        println("최종 우승자 : $winners")
    }
}