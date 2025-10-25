package racingcar.view
import camp.nextstep.edu.missionutils.Console

class InputView{
    fun readCarNames(): List<String>
    {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        val names = input.split(",").map { it.trim() }
        validateCarNames(names)
        return names
    }
    private fun validateCarNames(names: List<String>) {
        if(names.any { it.isEmpty() }) throw IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.")
        if(names.any { it.length >5 }) throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
    }
    fun readTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해야 합니다.")
    }
}