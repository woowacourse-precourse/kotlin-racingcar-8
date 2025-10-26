package racingcar.controller

import racingcar.exception.CarNameInputValidator
import racingcar.exception.CountAttemptInputValidator
import racingcar.model.*
import racingcar.view.*

class RacingGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val carNamesValidator: CarNameInputValidator,
    private val countAttemptValidator: CountAttemptInputValidator,
    private val parser: Parser
) {

    fun run() {

        // 자동차 이름 입력 및 검증
        outputView.printCarNameInputMessage()
        val carNamesInput = inputView.readCarNameInput()
        carNamesValidator.validateCarName(carNamesInput)

        // 시도 횟수 입력 및 검증
        outputView.printCountOfAttemptMessage()
        val countAttemptInput = inputView.readAttemptCountInput()
        countAttemptValidator.validateCountAttempt(countAttemptInput)

        // 레이싱 게임 준비물
        val numberGenerator = RandomNumberGenerator()
        val movementRule = MovementRule(numberGenerator)
        val cars = parser.parseCarName(carNamesInput)
        val singleMove = SingleCarMover()
        val carsMover = CarsMover(singleMove, movementRule)
        val game = RacingGame(cars, countAttemptInput.toInt())

        // 게임 진행
        outputView.printExecutionResultMessage()
        game.start(carsMover)
        val winners = FinalWinner().findWinners(cars)
        outputView.printFinalWinner(winners)

    }
}

