package day5

import day4.isPairContained
import java.io.File
import java.util.ArrayDeque


fun day1() {
    val path = System.getProperty("user.dir")
    var stackFlag = false
    val stackList = mutableMapOf<Int, ArrayDeque<Char>>()
    val text = File("$path/day5/day5input.txt").readLines().forEach {

        if (!stackFlag and !it.contains("[0-9]".toRegex())) {
            val splitLine = it.split(" [")
            for (i in splitLine.indices) {
                if (!stackList.containsKey(i)) {
                    stackList[i] // placeholder
                }
            }


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