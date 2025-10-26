package racingcar.model

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.assertj.core.api.Assertions.assertThat
import java.util.stream.Stream
import org.junit.jupiter.params.provider.Arguments

class CarMoverTest() {

    private lateinit var car: Car

    @BeforeEach
    fun setup() {
        car = Car("testCar", 0)
    }

    @Test
    fun `초기 위치는 0`() {

        assertThat(car.position).isEqualTo(0)
    }


    @ParameterizedTest
    @MethodSource("singleMovementBoundaryConditions")
    fun `단일 이동시 위치 확인`(
        movementResult: Boolean, expectedPosition: Int
    ) {
        SingleCarMover().move(car, movementResult)
        assertThat(car.position).isEqualTo(expectedPosition)
    }


    @ParameterizedTest
    @MethodSource("continuousMovementBoundaryConditions")
    fun `연속 이동시 누적 위치 확인`(
        movementResult: Boolean, expectedPosition: Int
    ) {
        SingleCarMover().move(car, movementResult)
        SingleCarMover().move(car, movementResult)
        SingleCarMover().move(car, movementResult)
        assertThat(car.position).isEqualTo(expectedPosition)
    }

    private companion object {
        @JvmStatic
        fun singleMovementBoundaryConditions(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(false, 0)
            )
        }

        @JvmStatic
        fun continuousMovementBoundaryConditions(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(true, 3),
                Arguments.of(false, 0)
            )
        }
    }
}

