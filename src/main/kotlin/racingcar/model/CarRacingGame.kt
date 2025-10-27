package racingcar.model

class CarRacingGame(
    val carList : List<Car>,
) {
    fun runRace(){
        carList.forEach { car ->
            car.move(RandomNumberGenerator().generate())
        }
    }

}