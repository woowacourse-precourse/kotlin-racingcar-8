package racingcar.view

class OutputView {
    fun printCarNameInputGuide() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printMovementTimeInputGuide() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printTextOfResult(){
        println()
        println("실행 결과")
    }

    fun printCurrentLocation(name: String, distance: Int) {
        print("$name : ")
        for(i in 1 .. distance) {
            print("-")
        }
        println()
    }

    fun printWinner(winners: List<String>) {
        print("최종 우승자 : ")
        for (winner in winners) {
            print(winner)
            if(winner == winners.last()) {
                break
            }
            print(", ")
        }
    }
}