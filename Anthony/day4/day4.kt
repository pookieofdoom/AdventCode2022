package day4

import java.io.File

fun day1() {
    var total = 0
    val path = System.getProperty("user.dir")
    val text = File("$path/day4/day4input.txt").readLines().forEach {
        if (isPairContained(it)) {
            total++
        }
    }
    println(total)
}

fun isPairContained(pairText: String): Boolean {

    val pairs = pairText.split(",")
    val numRange1 = pairs[0].split("-")
    val numRange2 = pairs[1].split("-")
    val firstElf = (numRange1[0].toInt()..numRange1[1].toInt()).toList()
    val secondElf = (numRange2[0].toInt()..numRange2[1].toInt()).toList()
    if (firstElf.containsAll(secondElf) or secondElf.containsAll(firstElf))
        return true


    return false
}


fun day2() {
    var total = 0
    val path = System.getProperty("user.dir")
    val text = File("$path/day4/day4input.txt").readLines().forEach {
        if (isPairContained2(it)) {
            total++
        }
    }
    println(total)
}

fun isPairContained2(pairText: String): Boolean {

    val pairs = pairText.split(",")
    val numRange1 = pairs[0].split("-")
    val numRange2 = pairs[1].split("-")
    val firstElf = (numRange1[0].toInt()..numRange1[1].toInt()).toList()
    val secondElf = (numRange2[0].toInt()..numRange2[1].toInt()).toList()
    if (firstElf.any(secondElf::contains)) {
        return true
    }


    return false
}

fun main() {
    day1()
    day2()
}