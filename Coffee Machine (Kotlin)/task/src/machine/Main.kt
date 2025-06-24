import java.util.Scanner

const val WATER = 200
const val MILK = 50
const val COFFEE_BEANS = 15

fun main() {
    val scanner = Scanner(System.`in`)

    println("Write how many ml of water the coffee machine has:")
    val water = scanner.nextInt()
    println("Write how many ml of milk the coffee machine has:")
    val milk = scanner.nextInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeans = scanner.nextInt()
    println("Write how many cups of coffee you will need:")
    val countCups = scanner.nextInt()

    val countCupsCanWeMake: (Int, Int, Int) -> Int = { waterValue, milkValue, coffeeBeansValue ->
        val waterCondition = waterValue / WATER
        val milkCondition = milkValue / MILK
        val coffeeBeansCondition = coffeeBeansValue / COFFEE_BEANS
        var res = waterCondition
        res = if (milkCondition < res) milkCondition else res
        res = if (coffeeBeansCondition < res) coffeeBeansCondition else res
        res
    }

    val count = countCupsCanWeMake(water, milk, coffeeBeans)

    when (countCups.compareTo(count)) {
        -1 -> println("Yes, I can make that amount of coffee (and even ${count - countCups} more than that)")
        1 -> println("No, I can make only $count cups of coffee")
        else -> println("Yes, I can make that amount of coffee")
    }
}