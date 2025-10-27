package racingcar

fun main() {
    val startRound = Round.startWith(RacingView.getNamesFromUser())
    val attempt = Attempt(RacingView.getAttemptFromUser())
    val racing = Racing.start(startRound, attempt)
    RacingView.showStatus(racing)
    RacingView.showWinner(racing)
}
