package racingcar

fun main() {
    val startRound = RacingView.getNamesFromUser()
    val attempt = RacingView.getAttemptFromUser()
    val racing = Racing.start(startRound, attempt)
    RacingView.showStatus(racing)
    RacingView.showWinner(racing)
}
