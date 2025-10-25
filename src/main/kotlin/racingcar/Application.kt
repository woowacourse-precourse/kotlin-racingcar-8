package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
}

// 입력받은 문자열에서 이름들을 추출하는 함수
fun extractRacerName(inputNameString: String): List<String> {
    var returnCollection: List<String> = mutableListOf<String>()
    returnCollection = inputNameString.split(",")

    return returnCollection
}

public class Racer(var name: String){
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
