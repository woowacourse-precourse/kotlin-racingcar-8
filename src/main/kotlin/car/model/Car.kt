package car.model

data class Car(
    val name: String,
    var position: Int = 0
){
    fun move(){
        position+=1
    }

    fun getPositionDisplay(): String {
        return "-".repeat(position)
    }
}