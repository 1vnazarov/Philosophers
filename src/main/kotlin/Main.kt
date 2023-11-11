import java.util.*
val random = Random()
val forks = Array(100) { false }
class Philosopher(private val position: Int, private val totalPhilosophers: Int) {
    fun startDinner() {
        val leftFork = position
        val rightFork = (position + 1) % totalPhilosophers
        if (random.nextBoolean()) {
            if (!forks[leftFork]) {
                forks[leftFork] = true
                println("Философ $position обедает левой вилкой")
                return
            }
            if (!forks[rightFork]) {
                forks[rightFork] = true
                println("Философ $position обедает правой вилкой")
                return
            }
        }
        else {
            if (!forks[rightFork]) {
                forks[rightFork] = true
                println("Философ $position обедает правой вилкой")
                return
            }
            if (!forks[leftFork]) {
                forks[leftFork] = true
                println("Философ $position обедает левой вилкой")
                return
            }
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
    val philosophers = Array(totalPhilosophers) { Philosopher(it, totalPhilosophers) }

    val startPhilosopherIndex = random.nextInt(totalPhilosophers)

    for (i in 0 until totalPhilosophers) {
        val philosopherIndex = (startPhilosopherIndex + i) % totalPhilosophers
        philosophers[philosopherIndex].startDinner()
    }
}
