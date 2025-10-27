package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Car(val name: String, var position: Int = 0) {
    companion object RandomNumber{
        private val RANDOM_MAX=9
        private val RANDOM_MIN=0
        private val MOVE_STANDARD=4
    }

    fun move(){
        if(checkMove()){
            position++
        }
    }

    fun printState(){
        println("$name : ${"-".repeat(position)}")
    }

    private fun checkMove(): Boolean{
        return Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX) >= MOVE_STANDARD
    }
}