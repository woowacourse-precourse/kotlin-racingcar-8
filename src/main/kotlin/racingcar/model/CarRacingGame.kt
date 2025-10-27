package racingcar.model

class CarRacingGame(
    val carList : List<Car>,
) {
    fun runRace(){
        carList.forEach { car ->
            car.move(RandomNumberGenerator().generate())
        }
    }

    fun getCurrentCarDistances(): Map<String, String>{
        return carList.associate { car ->
            car.name to car.getDistanceWithHyphen()
        }
    }

    fun getWinners(): List<String> {
        val maxPosition = carList.maxOfOrNull { it.getDistance() } ?: 0
        return carList
            .filter { it.getDistance() == maxPosition }
            .map { it.name }
    }

}