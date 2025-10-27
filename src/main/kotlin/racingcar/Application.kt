package racingcar

import camp.nextstep.edu.missionutils.Console

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNamesInput = Console.readLine()
        val cars = CarFactory.createCars(carNamesInput)

        println("시도할 횟수는 몇 회인가요?")
        val attemptCountInput = Console.readLine()
        val attemptCount = AttemptCountParser.parse(attemptCountInput)

        println()
        println("실행 결과")

        val game = RacingGame(cars)

        repeat(attemptCount) {
            game.runOneRound()
            OutputView.printRoundStatus(game.getCarsSnapshot())
            println()
        }

        val winners = WinnerResolver.resolveWinners(game.getCarsSnapshot())
        OutputView.printWinners(winners)
    }
}
