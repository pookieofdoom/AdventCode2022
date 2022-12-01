
import java.io.File


fun main() {
    val text = File("day1input.txt").readText()
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