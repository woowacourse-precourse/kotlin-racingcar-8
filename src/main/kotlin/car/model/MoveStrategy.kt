package car.model

interface MoveStrategy {
    fun shouldMove(): Boolean
}