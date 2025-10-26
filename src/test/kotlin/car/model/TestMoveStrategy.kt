package car.model

class AlwaysMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean = true
}

class NeverMoveStrategy : MoveStrategy {
    override fun shouldMove(): Boolean = false
}

