import java.util.*

class Philosopher(private val position: Int, private val totalPhilosophers: Int) {
    fun startDinner(forks: Array<Boolean>) {
        val leftFork = position
        val rightFork = (position + 1) % totalPhilosophers
        if (Random().nextInt(0, 1) == 0)
            if (!forks[leftFork]) {
                forks[leftFork] = true
                println("Философ $position обедает левой вилкой")
                return
            }
        else
            if (!forks[rightFork]) {
                forks[rightFork] = true
                println("Философ $position обедает правой вилкой")
                return
            }
        println("Философ $position размышляет")
    }
}

fun main() {
    var totalPhilosophers: Int?
    do {
        print("Введите количество философов: ")
        totalPhilosophers = readlnOrNull()?.toIntOrNull()
    } while (totalPhilosophers == null || totalPhilosophers <= 1)
    val forks = Array(totalPhilosophers) { false }
    val philosophers = Array(totalPhilosophers) { Philosopher(it, totalPhilosophers) }

    val startPhilosopherIndex = Random().nextInt(totalPhilosophers)

    for (i in 0 until totalPhilosophers) {
        val philosopherIndex = (startPhilosopherIndex + i) % totalPhilosophers
        philosophers[philosopherIndex].startDinner(forks)
    }
}
