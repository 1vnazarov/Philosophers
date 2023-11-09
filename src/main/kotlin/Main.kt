import java.util.*

class Philosopher(private val position: Int, private val totalPhilosophers: Int) {
    fun startDinner(forks: Array<Boolean>) {
        val leftFork = position
        val rightFork = (position + 1) % totalPhilosophers

        if (!forks[leftFork] && !forks[rightFork]) {
            forks[leftFork] = true
            forks[rightFork] = true
            println("Философ $position обедает")
        } else {
            println("Философ $position размышляет")
        }
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

    val random = Random()
    val startPhilosopherIndex = random.nextInt(totalPhilosophers)

    for (i in 0 until totalPhilosophers) {
        val philosopherIndex = (startPhilosopherIndex + i) % totalPhilosophers
        philosophers[philosopherIndex].startDinner(forks)
    }
}
