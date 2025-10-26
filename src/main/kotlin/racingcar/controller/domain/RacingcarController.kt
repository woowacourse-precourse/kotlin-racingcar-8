package racingcar.controller.domain

import racingcar.view.domain.Guide

object RacingcarController {
    fun run() {
        Guide.consoleName();

        Guide.consoleAttempt();
    }
}