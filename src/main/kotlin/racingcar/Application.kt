package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

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

fun PlayerNameInputErrorCheck(Name: String){
    if(Name.length > 5){
        throw IllegalArgumentException("이름은 5글자 이상이 될 수 없습니다.")
    }
    else if (Name.isEmpty()){
        throw IllegalArgumentException("이름은 공백이 될 수 없습니다.")
    }
}

fun FindCurrentMostMove(PlayerList: List<String>, PlayerProgressBarArray: Array<String>): Int{
    var CurrentMostForwardCount: Int = 0
    for(i in 0 until PlayerList.size){
        var RandomNumber = pickNumberInRange(0, 9)
        val Moved = PlayerForward(RandomNumber, i, PlayerProgressBarArray)
        CurrentMostForwardCount = Math.max(CurrentMostForwardCount, Moved)
    }
    return CurrentMostForwardCount
}

fun PrintRacingProcess(PlayerList: List<String>, PlayerProgressBarArray: Array<String>){
    for(i in 0 until PlayerList.size){
        println("${PlayerList[i]} : ${PlayerProgressBarArray[i]}")
    }

}

fun PlayerForward(RandomNumber: Int, Index: Int, PlayerProgressBarArray: Array<String>): Int{
    var PlayerForwardCount: Int = 0
    if (RandomNumber >= 4) {
        PlayerProgressBarArray[Index] += "-"
        PlayerForwardCount = PlayerProgressBarArray[Index].length
    }
    return PlayerForwardCount
}

fun FindRacingWinner(PlayerProgressBarArray: Array<String>, PlayerList: List<String>, MostForwardCount: Int, Index: Int, Final: StringBuilder){
    if(PlayerProgressBarArray[Index].length == MostForwardCount){
        RecordRacingWinner(Index, PlayerList, Final)
    }
}

fun RecordRacingWinner(Index: Int, PlayerList: List<String>, Final: StringBuilder){
    if(Final.isEmpty()){
        Final.append(PlayerList[Index])
    }
    else{
        Final.append(", " + PlayerList[Index])
    }
}




