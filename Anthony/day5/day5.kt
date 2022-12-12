package day5

import day4.isPairContained
import java.io.File
import java.util.ArrayDeque

class SupplyStacks {
    val supplyStacks = listOf<ArrayDeque<Char>>()


}


fun day1() {
    val path = System.getProperty("user.dir")
    var stackFlag = false
    val text = File("$path/day5/day5input.txt").readLines().forEach {

        if (!stackFlag and !it.contains("[0-9]".toRegex())) {
            println(it.split("   "))
        } else {
            if (!stackFlag) {
                println(it.split("   "))
            }
            stackFlag = true

        }

        // mapInputToStacks(it)
    }
    val stack = ArrayDeque<Int>()
}


fun mapInputToStacks(text: String) {


}

fun main() {
    day1()
}