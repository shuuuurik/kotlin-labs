fun main() {
    val numbers = readIntSequence()
    val statistics = findStatistics(numbers)
    println("Вы ввели последовательность: $numbers")
    println("Максимальное значение: ${statistics.max}")
    println("Минимальное значение: ${statistics.min}")
    println("Среднее значение: ${statistics.mean}")
}

fun readIntSequence() : List<Int> {
    val ints = mutableListOf<Int>()
    while(true) {
        print("Введите число или 'done'> ")
        val string = readlnOrNull()
        if (string == null || string.trim() == "done") break
        try {
            val number = string.toInt()
            ints.add(number)
        } catch (_: NumberFormatException) {
            println("Вы ввели не число")
        }
    }
    return ints
}

data class IntStatistics(val min: Int, val max: Int, val mean: Float)

fun findStatistics(numbers: List<Int>) : IntStatistics {
    val sortedNumbers = numbers.sorted()
    val minimum = sortedNumbers.first()
    val maximum = sortedNumbers.last()
    val mean = sortedNumbers.reduce { sum, element -> sum + element } / sortedNumbers.size.toFloat()
    return IntStatistics(minimum, maximum, mean)
}
