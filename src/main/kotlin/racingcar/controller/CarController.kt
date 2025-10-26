package racingcar.controller

import racingcar.model.Car

class CarController(var carList: List<Car>) {

    // 현재까지의 자동차 움직임을 결정하는 함수
    fun currentMoving(): List<Car> {
        for (i in carList) {
            i.moving()
        }
        return carList
    }

    // 우승자를 결정하는 함수
    fun winner(): List<String> {
        val best: Int = carList.maxOf{ it.moves } // 가장 높은 움직임 수
        val winnerList = carList.filter{ it.moves == best }.map{ it.name } // 우승자 리스트
        return winnerList
    }
}