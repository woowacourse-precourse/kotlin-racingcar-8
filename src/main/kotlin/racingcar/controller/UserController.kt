package racingcar.controller

import racingcar.application.converter.Converter
import racingcar.application.converter.StringToIntConverter
import racingcar.application.converter.StringToListConverter
import racingcar.application.validator.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class UserController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val carNameValidator: Validator,
) {
    fun run() {
        outputView.printCarNamesPrompt()
        val readCarNames = inputView.readCarNames()
        carNameValidator.validate(readCarNames)
        outputView.printAttemptCountPrompt()
        val readAttemptCount = inputView.readAttemptCount()
        convert(StringToListConverter(), readCarNames)
        convert(StringToIntConverter(), readAttemptCount)
    }

    private fun convert(converter: Converter<Any>, input: String): Any {
        return converter.convert(input)
    }

}