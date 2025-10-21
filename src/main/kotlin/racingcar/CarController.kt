package racingcar

// 자동차가 움직이는 것을 관리하는 컨트롤러
class CarController (val carlist: List<Car>){
    companion object {
        // 움직임을 나타낼 상수
        const val MOVE_STRING: String = "-"
    }

    // 각 자동차를 움직이거나 멈추게 하는 함수
    fun carMoving() {
        for (i in carlist) {
            i.moving()
        }
    }

    // 현재까지의 자동차 움직임을 나타내주는 함수
    fun currentMoving() {
        for (i in carlist) {
            println("${i.name} : ${MOVE_STRING.repeat(i.moves)}")
        }
    }

    // 우승자를 찾아내는 함수
    fun winner(): List<String> {
        val best: Int = carlist.maxOf{ it.moves } // 가장 높은 움직임 수
        val win = carlist.filter{ it.moves == best }.map{ it.name } // 우승자 리스트
        return win
    }
}