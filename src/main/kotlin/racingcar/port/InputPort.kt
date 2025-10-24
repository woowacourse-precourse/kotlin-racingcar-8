package racingcar.port

interface InputPort {
    fun readCarNames(): String?
    fun readTryCount(): String?
}