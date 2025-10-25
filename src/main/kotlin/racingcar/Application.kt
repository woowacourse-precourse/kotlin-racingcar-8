package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    // TODO: 프로그램 구현
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
