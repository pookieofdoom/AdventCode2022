import java.io.File

fun day1(){
    val path = System.getProperty("user.dir")
    var total = 0
    val text = File("$path/day2/day2input.txt").readLines().forEach{
        total += processPoints(it)
    }
    println(total)
}


fun processPoints(input: String): Int {
    val splitInput = input.split(' ')
    var shapeValue = 0
    when (splitInput[1]) {
        "X" -> shapeValue = 1
        "Y" -> shapeValue = 2
        "Z" -> shapeValue = 3
    }

    return processWin(splitInput) + shapeValue
}

fun processWin(input: List<String>) : Int {
    when (input[0]) {
        "A" -> {
            return if (input[1] == "X") 3
            else if (input[1] == "Y") 6
            else 0

        }
        "B" -> {
            return if (input[1] == "X") 0
            else if (input[1] == "Y") 3
            else 6

        }
        "C" -> {
            return if (input[1] == "X") 6
            else if (input[1] == "Y") 0
            else 3

        }
    }
    return -69
}




fun day2() {
    val path = System.getProperty("user.dir")
    var total = 0
    val text = File("$path/day2/day2input.txt").readLines().forEach{
        total += processPoints2(it)
    }
    println(total)
}
fun processPoints2(input: String): Int {
    val splitInput = input.split(' ')
    var shapeValue = 0
    when (splitInput[1]) {
        "X" -> shapeValue = 0
        "Y" -> shapeValue = 3
        "Z" -> shapeValue = 6
    }

    return processWin2(splitInput) + shapeValue
}
fun processWin2(input: List<String>) : Int {
    when (input[0]) {
        "A" -> {
            return if (input[1] == "X") 3
            else if (input[1] == "Y") 1
            else 2

        }
        "B" -> {
            return if (input[1] == "X") 1
            else if (input[1] == "Y") 2
            else 3

        }
        "C" -> {
            return if (input[1] == "X") 2
            else if (input[1] == "Y") 3
            else 1

        }
    }
    return -69
}


fun main() {
    day1()
    day2()
}