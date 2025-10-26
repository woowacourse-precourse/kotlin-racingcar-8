package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var PlayerNameInput: String = readLine()
    PlayerNameInput = PlayerNameInput.replace(" ", "")
    var PlayerList = PlayerNameInput.split(",")

    for (i in PlayerList) {
        PlayerNameInputErrorCheck(i)
    }

    println("시도할 횟수는 몇 회인가요?")
    var PlayCountInput: String = readLine()
    var PlayCount: Int = 0
    try {
        PlayCount = Integer.parseInt(PlayCountInput)
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("횟수는 숫자만 입력되어야만 합니다!")
    }

    var PlayerProgressBarArray = Array<String>(PlayerList.size) {""}
    var MostForwardCount: Int = 0

    for(i in 0 until PlayCount){
        MostForwardCount = FindCurrentMostMove(PlayerList, PlayerProgressBarArray)
        PrintRacingProcess(PlayerList, PlayerProgressBarArray)
        println()
    }

    var Final = StringBuilder()

    for(i in 0 until PlayerList.size){
        FindRacingWinner(PlayerProgressBarArray, PlayerList, MostForwardCount, i, Final)
    }

    print("최종 우승자 : $Final")
}


