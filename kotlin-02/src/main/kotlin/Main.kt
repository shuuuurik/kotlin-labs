import kotlin.math.pow

fun main() {
    /*1*/
//    runTask1()
    /*2*/
//    runTask2()
    /*3*/
//    runTask3()
    /*4*/
//    runTask4()
    /*5*/
    runTask5()
}

//region task1

fun runTask1 () {
    fun callTwice(expression: (Int) -> Unit) {
        expression(4);
        expression(41);
    }
    callTwice { a -> println(a) }
    println()
    callTwice { a -> println(2*a) }
    println()
    callTwice { a ->
        if(a%2 == 1)
            println("Нечетное")
        else
            println("Четное")
    }
}

//endregion

//region task2

fun runTask2 () {
    fun callAndPrint (expression: (Double) -> Double) {
        println(expression(25.0).toInt());
        println(expression(16.0).toInt());
        println(expression(157.0).toInt());
    }

    callAndPrint { a: Double -> (a.toInt() % 13).toDouble() }
    println()
    callAndPrint { a: Double -> a.pow(2) }
}

//endregion

//region task3

fun runTask3 () {
    //fun createMultiplier(coefficient: Double): (Double) -> Double {
    //    return { a: Double -> a * coefficient}
    //}
    fun createMultiplier(coefficient: Double): (Double) -> Double = { a: Double -> a * coefficient }

    fun callAndPrint (expression: (Double) -> Double) {
        println(expression(25.0).toInt());
        println(expression(16.0).toInt());
        println(expression(157.0).toInt());
    }

    callAndPrint ( createMultiplier(10.0) )
    println()
    callAndPrint ( createMultiplier(7.0) )
    println()
    val a = createMultiplier(1.0);
    val b = createMultiplier(1.0);
    if (a != b)
        println("Лямбда-выражения разные")
    if (a(5.0) == b(5.0))
        println("Результат вызова данных лямбда-выражений одинаковый")
}

//endregion

//region task4

fun interface DoubleTransformer {
    fun transform(number: Double): Double
}

fun callAndPrint2(expression: DoubleTransformer) {
    println(expression.transform(25.0).toInt());
    println(expression.transform(16.0).toInt());
    println(expression.transform(157.0).toInt());
}

fun runTask4 () {
    fun createMultiplier2(coefficient: Double): DoubleTransformer = DoubleTransformer{it * coefficient}

    callAndPrint2 { (it.toInt() % 13).toDouble()}
    println()
    callAndPrint2 ( createMultiplier2(7.0) )
}

//endregion

//region task5

fun runTask5 () {
    class PolynomialCalculator(val coefs: List<Int>): DoubleTransformer {
        override fun transform(number: Double): Double {
            var res = 0.0;
            for (index in 0 until coefs.size) {
                res += coefs[index] * number.pow(index);
            }
            return res;
        }
    }
    val instanceCalculator = PolynomialCalculator(listOf(7, -5, 2));
    callAndPrint2(instanceCalculator);
}

//endregion



