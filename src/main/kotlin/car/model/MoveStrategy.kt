package car.model

// 움직임의 여부를 결정하는 전략 인터페이스
interface MoveStrategy {
    fun shouldMove(): Boolean
}