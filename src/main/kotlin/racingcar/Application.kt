package racingcar

fun main() {
    val startRound = Round.startWith(InputView.getNamesFromUser())
    val attempt = Attempt(InputView.getAttemptFromUser())
    val racing = Racing.start(startRound, attempt)
    val outputView = OutputView(attempt)
    outputView.showStatus(racing)
    outputView.showWinner(racing)
}
