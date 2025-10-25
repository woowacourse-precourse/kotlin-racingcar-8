package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // 입력 화면 출력
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val racerNames: String = Console.readLine()

    //공백 입력시
    if(racerNames.isEmpty()) {
        println("아무도 입력되지 않아 경기가 진행되지 않습니다.")
        return
    }

    // 레이서 이름 추출 및 잘못된 입력에 대한 예외처리
    val extractedRacerNames = extractRacerName(racerNames)

    validateNameInput(extractedRacerNames)

    // 레이서 객체 생성
    val racerCollection: List<Racer> = extractedRacerNames.map { Racer(it) }

    //시도 횟수 입력
    println("시도할 횟수는 몇 회인가요?")
    val attemptNumbers: Int = Console.readLine().toInt()

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

// 잘못된 이름에 대한 예외처리
fun validateNameInput(inputNameString: List<String>) {
    var invalidName = StringBuilder()
    for (name in inputNameString) {
        //자동차 이름이 5자 이상인 경우
        if (name.length > 5) { invalidName.append("$name ") }
    }

    if (!invalidName.isEmpty()) {
        throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. (5자 이상인 이름 : ${invalidName})")
    }
}

// 우승자 선별 함수
fun getWinner(collection: List<Racer>): String{
    val winner = StringBuilder().append("최종 우승자 : ")
    if(collection.isEmpty()){
        return winner.toString()
    }

    val maxDistance = collection.maxOfOrNull { it.getFinalDistance() }

    val winners = collection.filter { it.getFinalDistance() == maxDistance }

    val winnerNames = winners.map { it.getName() }

    winner.append(winnerNames.joinToString(","))

    return winner.toString()
}

class Racer(var nameInput: String){
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