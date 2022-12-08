package day3

import java.io.File

fun day1() {
    val path = System.getProperty("user.dir")
    var total = 0
    val text = File("$path/day3/day3input.txt").readLines().forEach {
        total += convertToPriority(duplicateCharacters(it))
    }
    println(total)
}


fun duplicateCharacters(text: String): Char {

    val item1List = mutableListOf<Char>()
    for (i in 0 until text.length / 2) {
        item1List.add(text[i])
    }

    for (i in text.length / 2 until text.length) {
        if (item1List.contains(text[i])) {
            return text[i]
        }
    }
    return '?'

}

fun convertToPriority(ch: Char): Int {
    val MAGIC_ASCII_UPPERCASE = 38
    val MAGIC_ASCII_LOWERCASE = 96
    var value = 0
    value = if (ch.isUpperCase()) {
        ch.code - MAGIC_ASCII_UPPERCASE
    } else {
        ch.code - MAGIC_ASCII_LOWERCASE
    }

    return value
}

fun day2() {
    val path = System.getProperty("user.dir")
    var total = 0
    val elfGroup = mutableListOf<String>()
    val text = File("$path/day3/day3input.txt").readLines().forEach {
        elfGroup.add(it)
        if (elfGroup.size == 3) {
            total += convertToPriority(duplicateCharactersWithinGroup(elfGroup))
            elfGroup.clear()
        }

    }
    println(total)
}

fun duplicateCharactersWithinGroup(elfGroupText: MutableList<String>): Char {
    var duplicateList = elfGroupText[0].toMutableList()
    for (i in 1 until elfGroupText.size) {
        duplicateList.retainAll(elfGroupText[i].toMutableList())
    }

    return duplicateList[0]
}

fun main() {
    day1()
    day2()
}