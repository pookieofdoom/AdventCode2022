package day1
import java.io.File


fun part1() {
    val path = System.getProperty("user.dir")
    val text = File("$path/day1/day1input.txt").readText()
    val textArray = text.split("\n").map {it.trim() }
    val calorieList = mutableListOf<Int>()

    var sum = 0
    for (item in textArray) {
        if (item.isEmpty() ) {

            calorieList.add(sum)
            sum = 0
        }
        else {
            sum += item.toInt()
        }
    }

    println(calorieList.maxOrNull()) //70613
}

fun part2() {
    val path = System.getProperty("user.dir")
    val text = File("$path/day1/day1input.txt").readText()
    val textArray = text.split("\n").map {it.trim() }
    val calorieList = mutableListOf<Int>()

    var sum = 0
    for (item in textArray) {
        if (item.isEmpty() ) {

            calorieList.add(sum)
            sum = 0
        }
        else {
            sum += item.toInt()
        }
    }

    calorieList.sortDescending()
    println(calorieList[0] + calorieList[1] + calorieList[2])
}

fun main() {
    part1()
    part2()
}