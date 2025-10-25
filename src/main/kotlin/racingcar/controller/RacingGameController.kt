package racingcar.controller

import racingcar.exception.CarNameInputValidator
import racingcar.exception.CountAttemptInputValidator
import racingcar.model.*
import racingcar.view.*

class RacingGameController(
    private val inputView: InputView,
    private val carNamesValidator: CarNameInputValidator,
    private val countAttemptValidator: CountAttemptInputValidator,
    private val parser: Parser
) {
    fun run() {
        val outputView = OutputView()

        outputView.printCarNameInputMessage()

        val carNamesInput = inputView.readCarNameInput()

        outputView.printCountOfAttemptMessage()

        val countAttemptInput = inputView.readAttemptCountInput()

        carNamesValidator.validateCarName(carNamesInput)
        countAttemptValidator.validateCountAttempt(countAttemptInput)

        val numberGenerator = RandomNumberGenerator()
        val movementRule = MovementRule(numberGenerator)
        val cars = parser.parseCarName(carNamesInput)
        val singleMove = SingleCarMover()
        val carsMover = CarsMover(singleMove, movementRule)
        val game = RacingGame(cars, countAttemptInput.toInt())
        val winners = FinalWinner().findWinners(cars)

        game.start(carsMover)

        outputView.printExecutionResultMessage()
        outputView.printFinalWinner(winners)

    }
}

