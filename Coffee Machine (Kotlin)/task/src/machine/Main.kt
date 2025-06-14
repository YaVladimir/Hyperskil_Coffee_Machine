import java.util.Scanner

const val WATER = 200
const val MILK = 50
const val COFFEE_BEANS = 15

fun main() {
    val scanner = Scanner(System.`in`)

    println("Write how many cups of coffee you will need:")
    val countCups = scanner.nextInt()

    println("For $countCups of coffee you will need:")
    println("${countCups * WATER} ml of water")
    println("${countCups * MILK} ml of milk")
    println("${countCups * COFFEE_BEANS} g of coffee beans")

}