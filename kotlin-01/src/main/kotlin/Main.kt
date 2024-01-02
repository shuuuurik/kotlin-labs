import kotlin.math.pow

fun main(args: Array<String>) {
//    println("Hello World!")

    //readInt("Введите целое число> ");
    val coefs = readCoefficients();
    val x = readInt("Введите х.");
    println("Значение многочлена в точке $x равно ${polynomValue(coefs, x)}")
    println("Значение производной многочлена в точке $x равно ${polynomValue(calcDerivative(coefs), x)}")
}

fun readInt(prompt: String) : Int {
    while(true) {
        println(prompt);
        var str = readlnOrNull();
        /*if (str !is String){
            continue;
        }*/
        try {
            if (str is String) {
                var n = str.toInt();
                return n;
            }
        } catch (e: Throwable) {
            println("Введено некорректное целое число. Попробуйте еще раз.")
            continue;
        }
    }
}

fun readCoefficients() : List<Int> {
    var n : Int;
    while (true) {
        n = readInt("Введите степень многочлена");
        if (n < 0) {
            println("Степень многочлена не может быть отрицательной.")
            continue;
        } else {
            break;
        }
    }
    //val list = mutableListOf<Int>()
    var coefficients = emptyList<Int>();
    for (i in n downTo 0){
        coefficients += readInt("Введите коэффициент перед $i степенью")
        //list.add(readInt("Введите $i-ый коэффициент"))
        //coefficients = coefficients.reversed();
    }
    return coefficients.reversed();
}

fun calcDerivative(coefs: List<Int>) : List <Int> {
    var newcoefs = mutableListOf<Int>();
    for (index in 1 until coefs.size) {
        newcoefs.add(coefs[index] * index);
    }
    return newcoefs;
}

fun polynomValue(coefs: List<Int>, point: Int) : Int {
    var res = 0;
    for (index in 0 until coefs.size) {
        res += coefs[index] * point.toFloat().pow(index).toInt();
    }
    return res;
}
