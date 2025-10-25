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
            println(racer.getDistance())
        }
        println()
    }

    print(getWinner(racerCollection))
}

// 입력받은 문자열에서 이름들을 추출하는 함수
fun extractRacerName(inputNameString: String): List<String> {
    var returnCollection: List<String> = mutableListOf<String>()
    returnCollection = inputNameString.split(",")

    return returnCollection
}

// 우승자 선별 함수
fun getWinner(collection: List<Racer>): String{
    val winner = StringBuilder().append("최종 우승자 : ")
    if(collection.isEmpty()){
        return winner.toString()
    }

    val maxDistance = collection.map { it.getFinalDistance() }.maxOrNull()

    val winners = collection.filter { it.getFinalDistance() == maxDistance }

    val winnerNames = winners.map { it.getName() }

    winner.append(winnerNames.joinToString(","))

    return winner.toString()
}

public class Racer(var nameInput: String){
    private var name = nameInput
    private var distance = StringBuilder()

    fun doRandomProgress(){
        if(Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance.append("-")
        }
    }

    fun getName(): String { return this.name }

    fun getDistance(): String {
        return this.name+" : "+this.distance.toString()
    }

    fun getFinalDistance(): Int {
        return this.distance.toString().length
    }
}
