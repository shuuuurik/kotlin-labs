import kotlin.math.*

fun main() {
    /*1*/
//    runTask1();
    /*2*/
//    runTask2();
    /*3*/
//    runTask3();
    /*4*/
    runTask4();
}

fun runTask1 () {
    val numbers = listOf(1, 55, 25, 32, 2, 67, 31, 33, 11, 25, 66, 81, 97, 43, 46, 81)
    val res = mutableListOf<Int>()
    println("1) С использованием цикла for")
    for (i in numbers){
        if (i % 2 == 1)
            res.add(i)
    }
    println("1.1) Нечетные числа - $res")
    res.clear()
    for (i in numbers){
        if (i % 3 != 0)
            res.add(i)
    }
    println("1.2) Не делятся без остатка на 3 - $res")
    res.clear()
    for (i in numbers.indices){
        if (numbers[i] % (i + 1) == 0)
            res.add(numbers[i])
    }
    println("1.3) Без остатка делятся на свой порядковый номер - $res")
    res.clear()

    println()
    println("2) С использованием функции forEach")
    numbers.forEach(){
        if (it % 2 == 1)
            res.add(it)
    }
    println("2.1) Нечетные числа - $res")
    res.clear()
    numbers.forEach{
        if (it % 3 != 0)
            res.add(it)
    }
    println("2.2) Не делятся без остатка на 3 - $res")
    res.clear()
    var count = 0
    numbers.forEach{
//        if (it % count == 0)
//            res.add(it)
//        count++
        if (it % ++count == 0)
            res.add(it)
    }
    println("2.3) Без остатка делятся на свой порядковый номер - $res")
    res.clear()

    println()
    println("3) С использованием функции filter")
    println("3.1) Нечетные числа - ${numbers.filter { it % 2 == 1 }}")
    println("3.2) Не делятся без остатка на 3 - ${numbers.filter { it % 3 != 0 }}")
    count = 0
    println("3.3) Без остатка делятся на свой порядковый номер - ${numbers.filter { it % (++count) == 0}}")

    println()
    println("4) С использованием функции forEachIndexed")
    numbers.forEachIndexed { _: Int, a: Int ->
        if (a % 2 == 1)
            res.add(a)
    }
    println("4.1) Нечетные числа - $res")
    res.clear()
    numbers.forEachIndexed { _: Int, a: Int ->
        if (a % 3 != 0)
            res.add(a)
    }
    println("4.2) Не делятся без остатка на 3 - $res")
    res.clear()
    numbers.forEachIndexed { index: Int, a: Int ->
        if (a % (index + 1) == 0)
            res.add(a)
    }
    println("4.3) Без остатка делятся на свой порядковый номер - $res")
    res.clear()

    println()
    println("5) С использованием функции filterIndexed")
    println("5.1) Нечетные числа - ${numbers.filterIndexed {_: Int, a: Int -> a % 2 == 1 }}")
    println("5.2) Не делятся без остатка на 3 - ${numbers.filterIndexed {_: Int, a: Int -> a % 3 != 0 }}")
    println("5.3) Без остатка делятся на свой порядковый номер - ${numbers.filterIndexed {index: Int, a: Int -> a % (index+1) == 0}}")
}

fun runTask2 () {
    data class Rectangle(val height: Int, val width: Int) {
        val perimeter: Int
            get() = height * 2 + width * 2
        val area: Int
            get() = height * width
    }

    val rectangles = listOf(
        Rectangle(12, 1),
        Rectangle(4, 6),
        Rectangle(5, 15),
        Rectangle(7, 32),
        Rectangle(45, 32),
        Rectangle(10, 12),
        Rectangle(3, 9),
    )
    val res = mutableListOf<Int>()
    val resD = mutableListOf<Double>()

    println("1) С использованием цикла for")
    for (i in rectangles){
        res.add(i.perimeter)
    }
    println("1.1) Список периметров данных прямоугольников - $res")
    res.clear()
    for (i in rectangles){
            res.add(i.area)
    }
    println("1.2) Список площадей данных прямоугольников - $res")
    res.clear()
    for (i in rectangles){
        res.add(i.height + i.width)
    }
    println("1.3) Список полупериметров прямоугольников - $res")
    res.clear()
    for (i in rectangles){
        resD.add(sqrt(i.height.toDouble().pow(2) + i.width.toDouble().pow(2)))
    }
    println("1.4) Список диагоналей прямоугольников - $resD")
    resD.clear()

    println()
    println("2) С использованием функции forEach")
    rectangles.forEach(){
        res.add(it.perimeter)
    }
    println("2.1) Список периметров данных прямоугольников - $res")
    res.clear()
    rectangles.forEach(){
        res.add(it.area)
    }
    println("2.2) Список площадей данных прямоугольников - $res")
    res.clear()
    rectangles.forEach(){
        res.add(it.height + it.width)
    }
    println("2.3) Список полупериметров прямоугольников - $res")
    res.clear()
    rectangles.forEach(){
        resD.add(sqrt(it.height.toDouble().pow(2) + it.width.toDouble().pow(2)))
    }
    println("2.4) Список диагоналей прямоугольников - $resD")
    resD.clear()

    println()
    println("3) С использованием функции forEachIndexed")
    rectangles.forEachIndexed{_: Int, it: Rectangle -> res.add(it.perimeter)}
    println("3.1) Список периметров данных прямоугольников - $res")
    res.clear()
    rectangles.forEachIndexed{_: Int, it: Rectangle -> res.add(it.area)}
    println("3.2) Список площадей данных прямоугольников - $res")
    res.clear()
    rectangles.forEachIndexed{_: Int, it: Rectangle -> res.add(it.height + it.width)}
    println("3.3) Список полупериметров прямоугольников - $res")
    res.clear()
    rectangles.forEachIndexed{_: Int, it: Rectangle -> resD.add(sqrt(it.height.toDouble().pow(2) + it.width.toDouble().pow(2)))}
    println("3.4) Список диагоналей прямоугольников - $resD")
    resD.clear()

    println()
    println("4) С использованием функции map")
    println("4.1) Список периметров данных прямоугольников - ${rectangles.map { a:Rectangle -> a.perimeter }}")
    println("4.2) Список площадей данных прямоугольников - ${rectangles.map { a:Rectangle -> a.area }}")
    println("4.3) Список полупериметров прямоугольников - ${rectangles.map { a:Rectangle -> a.height + a.width }}")
    println("4.4) Список диагоналей прямоугольников - ${rectangles.map { a: Rectangle -> sqrt(a.height.toDouble().pow(2) + a.width.toDouble().pow(2)) }}")
    resD.clear()

    println()
    println("5) С использованием функции mapIndexed")
    println("5.1) Список периметров данных прямоугольников - ${rectangles.mapIndexed { _:Int, a:Rectangle -> a.perimeter }}")
    println("5.2) Список площадей данных прямоугольников - ${rectangles.mapIndexed { _:Int, a:Rectangle -> a.area }}")
    println("5.3) Список полупериметров прямоугольников - ${rectangles.mapIndexed { _:Int, a:Rectangle -> a.height + a.width }}")
    println("5.4) Список диагоналей прямоугольников - ${rectangles.mapIndexed { _:Int, a: Rectangle -> sqrt(a.height.toDouble().pow(2) + a.width.toDouble().pow(2)) }}")
    resD.clear()
}

fun runTask3 () {
    val strings = listOf(
        "apple",
        "Orange",
        "Peach",
        "Banana",
        "Tangerine",
        "Grapefruit",
        "Kiwi",
    )
    var flag: Boolean

    println("\n-----------> 1) С использованием цикла for <-----------")
    println("1.1")
    flag = true
    for(i in strings){
        if (i[0].isLowerCase()) {
            flag = false
            println("Строка $i начинается не с заглавной буквы")
            break
        }
    }
    if(flag)
        println("Все строки начинаются с заглавной буквы")

    println("\n1.2")
    flag = false
    for(i in strings){
        if (i.length == 5) {
            flag = true
            println("Есть строка длины 5 - $i")
            break
        }
    }
    if(!flag)
        println("Нет строк длины 5")

    println("\n1.3")
    flag = true
    for(str in strings){
        if (!str.matches(Regex("[^aeiouy]*[aeiouy][^aeiouy]*[aeiouy][^aeiouy]*", RegexOption.IGNORE_CASE))){
            println("В слове $str не содержатся ровно 2 гласные буквы")
            flag = false
        }
    }
    if(flag)
        println("Во всех строках встречается ровно 2 гласные буквы")

    println("\n1.4")
    flag = true
    for(str in strings){
        if (!str.matches(Regex("[^а-я]*", RegexOption.IGNORE_CASE))){
            println("В слове $str содержатся русские буквы")
            flag = false
        }
    }
    if(flag)
        println("Во всех строках отсутствуют русские буквы")

    println("\n-----------> 2) С использованием функции forEach <-----------")
    println("2.1")
    flag = true
    strings.forEach{
        if (!it.matches(Regex("[A-Z].*"))) {
            flag = false
            println("Строка $it начинается не с заглавной буквы")
        }
    }
    if(flag)
        println("Все строки начинаются с заглавной буквы")

    println("\n2.2")
    flag = false
    strings.forEach{
        if (it.length == 5) {
            flag = true
            println("Есть строка длины 5 - $it")
        }
    }
    if(!flag)
        println("Нет строк длины 5")

    println("\n2.3")
    flag = true
    strings.forEach{
        if (!it.matches(Regex("[^aeiouy]*[aeiouy][^aeiouy]*[aeiouy][^aeiouy]*", RegexOption.IGNORE_CASE))){
            println("В слове $it не содержатся ровно 2 гласные буквы")
            flag = false
        }
    }
    if(flag)
        println("Во всех строках встречается ровно 2 гласные буквы")

    println("\n2.4")
    flag = true
    strings.forEach{
        if (!it.matches(Regex("[^а-я]*", RegexOption.IGNORE_CASE))){
            println("В слове $it содержатся русские буквы")
            flag = false
        }
    }
    if(flag)
        println("Во всех строках отсутствуют русские буквы")

    println("\n-----------> 3) С использованием функции all <-----------")
    println("3.1")
    if(strings.all{ it.matches(Regex("[A-Z].*")) })
        println("Все строки начинаются с заглавной буквы")
    else
        println("Не все строки начинаются с заглавной буквы")

    println("\n3.2")
    if(strings.all{ it.length != 5 })
        println("Нет строк длины 5")
    else
        println("Есть строки длины 5")

    println("\n3.3")
    if(strings.all{ it.matches(Regex("[^aeiouy]*[aeiouy][^aeiouy]*[aeiouy][^aeiouy]*", RegexOption.IGNORE_CASE)) })
        println("Во всех строках встречаются ровно 2 гласные буквы")
    else
        println("Не во всех строках встречаются ровно 2 гласные буквы")

    println("\n3.4")
    if(strings.all{ it.matches(Regex("[^а-я]*", RegexOption.IGNORE_CASE)) })
        println("Во всех строках отсутствуют русские буквы")
    else
        println("Не во всех строках отсутствуют русские буквы")

    println("\n-----------> 4) С использованием функции any <-----------")
    println("\n4.1")
    if(strings.any{ !it.matches(Regex("[A-Z].*")) })
        println("Не все строки начинаются с заглавной буквы")
    else
        println("Все строки начинаются с заглавной буквы")

    println("\n4.2")
    if(strings.any{ it.length == 5 })
        println("Есть строки длины 5")
    else
        println("Нет строк длины 5")

    println("\n4.3")
    if(strings.any{ !it.matches(Regex("[^aeiouy]*[aeiouy][^aeiouy]*[aeiouy][^aeiouy]*", RegexOption.IGNORE_CASE)) })
        println("Не во всех строках встречаются ровно 2 гласные буквы")
    else
        println("Во всех строках встречаются ровно 2 гласные буквы")

    println("\n4.4")
    if(strings.any{ !it.matches(Regex("[^а-я]*", RegexOption.IGNORE_CASE)) })
        println("Не во всех строках отсутствуют русские буквы")
    else
        println("Во всех строках отсутствуют русские буквы")

    println("\n-----------> 5) С использованием функции none <-----------")
    println("5.1")
    if(strings.none{ !it.matches(Regex("[A-Z].*")) })
        println("Все строки начинаются с заглавной буквы")
    else
        println("Не все строки начинаются с заглавной буквы")

    println("\n5.2")
    if(strings.none{ it.length == 5 })
        println("Нет строк длины 5")
    else
        println("Есть строки длины 5")

    println("\n5.3")
    if(strings.none{ !it.matches(Regex("[^aeiouy]*[aeiouy][^aeiouy]*[aeiouy][^aeiouy]*", RegexOption.IGNORE_CASE)) })
        println("Во всех строках встречаются ровно 2 гласные буквы")
    else
        println("Не во всех строках встречаются ровно 2 гласные буквы")

    println("\n5.4")
    if(strings.none{ !it.matches(Regex("[^а-я]*", RegexOption.IGNORE_CASE)) })
        println("Во всех строках отсутствуют русские буквы")
    else
        println("Не во всех строках отсутствуют русские буквы")
}

fun runTask4 () {
    println("\n4.1")
    val numbers = listOf(0, 1, -2, -3, 4, -5, 6, -7, 8, 0, 10, 11)
    val res = mutableListOf<Int>()
    var count = 0
    var isPreviousPositive = true
    numbers.forEachIndexed { index: Int, a: Int ->
        val isCurrentPositive = a >= 0
        if (index != 0 && isPreviousPositive != isCurrentPositive){
            res.add(index + 1) // Позиции нумеруются с 1, а индексы - с 0
            count++
        }
        isPreviousPositive = isCurrentPositive
    }
    println("Знак меняется $count раз(-а) на позициях: $res")

    println("\n4.2")
    println("У этих элементов индексы являются степенями двойки: ")
    numbers.forEachIndexed { index: Int, a: Int ->
        if (index != 0 && log2(index.toDouble()) == floor(log2(index.toDouble())))
            print("$a ")
    }

    println("\n\n4.3")
    println("Модифициованный массив без нулей: ${numbers.filter { it != 0 }}")

    println("\n4.4")
    val digit = 5; // Подставляем сюда k (считывать через консоль лень и неудобно)
    println("Модифициованный массив с элементами, оканчивающимися на цифру $digit: ${numbers.map { it * 10 + /*(it > 0 ? digit : -digit)*/ (if (it >= 0) digit else -digit) }}")
    //println("Модифициованный массив с элементами, оканчивающимися на цифру 5: ${numbers.map { (it.toString() + "5").toInt()}}")
    //Math.pow(10.0, ceil(log10(abs(it).toDouble()

    println("\n4.5")
    val numbers2 = listOf(1234, 2323, 3456, 3333, 1560)
    println("Элементы массива, у которых сумма первых двух цифр равна сумме двух последних ${numbers2.filter { (it % 10 + (it % 100) / 10) == ((it % 1000) / 100 + (it % 10000) / 1000)}}")
}