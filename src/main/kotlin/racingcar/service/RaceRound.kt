package racingcar.service

import racingcar.domain.Car
import racingcar.domain.MoveDecider

class RaceRound(private val decider: MoveDecider){
    /**
     * 모든 자동차에 대해 한 번의 전진 여부를 판단하고 이동을 적용한다.
     * @return 각 자동차가 이동했는지 여부(Boolean)의 리스트 (입력 cars 순서 유지)
     */
    fun runOnce(cars: List<Car>): List<Boolean> {
        return cars.map { it.moveIf(decider) }
    }
}