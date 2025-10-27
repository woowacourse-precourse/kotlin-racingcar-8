package racingcar

class Car(val name: String, val position: Int = 0) {
    companion object RandomNumber{
        private val RANDOM_MAX=9
        private val RANDOM_MIN=0
        private val MOVE_STANDARD=4
    }

    fun move(){

    }

    fun printState(){
        println("$name : ${"-".repeat(position)}")
    }
}