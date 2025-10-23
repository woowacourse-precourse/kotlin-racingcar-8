package racingcar.view

object OutputView {
    private const val CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    private const val ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"

    fun displayCarNamePrompt() {
        println(CAR_NAME_PROMPT)
    }

    fun displayAttemptCountPrompt() {
        println(ATTEMPT_COUNT_PROMPT)
    }
}