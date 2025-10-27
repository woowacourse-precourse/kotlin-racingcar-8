package  racingcar.domain

class Car(val name: String){
    var position:Int =0
        private  set
    init{
        validateName(name)
    }
    fun moveIf(decider: MoveDecider): Boolean{
        val willMove=decider.canMove()
        if(willMove) position +=1
        return willMove
    }
    private fun validateName(name: String){
        if(name.isBlank()) throw IllegalArgumentException("Name can't be blank")
        if(name.length !in 1..5) throw IllegalArgumentException("Name length must be 1<=..<=5")
    }
}
