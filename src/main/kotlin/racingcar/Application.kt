package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 입력 화면 출력
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    var racerNames: String = Console.readLine()
    println("시도할 횟수는 몇 회인가요?")
    var attemptNumbers: Int = Console.readLine().toInt()

    // 레이서 객체 생성
    var extractedRacerNames = extractRacerName(racerNames)
    var racerCollection: List<Racer> = extractedRacerNames.map { Racer(it) }

    //경기 수행
    println("실행 결과")
    for(i in 1..attemptNumbers){
        for(racer in racerCollection){
            racer.doRandomProgress()
        }
        for(racer in racerCollection){
            println(racer.getLastDistance())
        }
        println()
    }
}

// 입력받은 문자열에서 이름들을 추출하는 함수
fun extractRacerName(inputNameString: String): List<String> {
    var returnCollection: List<String> = mutableListOf<String>()
    returnCollection = inputNameString.split(",")

    return returnCollection
}

public class Racer(var nameInput: String){
    private var name = nameInput
    private var distance = StringBuilder()
    private var distanceNumber: Int = 0

    fun doRandomProgress(){
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance.append("-")
            this.distanceNumber += 1
        }
    }

    fun getName(): String { return this.name }

    fun getDistance(): String { return this.distance.toString() }

    fun getLastDistance(): String {
        return this.name+" : "+this.distance.toString()
    }
}
