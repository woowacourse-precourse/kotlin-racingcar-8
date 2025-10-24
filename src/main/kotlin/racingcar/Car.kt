package racingcar

import camp.nextstep.edu.missionutils.Randoms
data class Car(
    val name: String,
    var position: Int = 0
) {
    fun move(){
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if(randomNumber >= 4) position++
        println("$name : ${"-".repeat(position)}")
    }
}
