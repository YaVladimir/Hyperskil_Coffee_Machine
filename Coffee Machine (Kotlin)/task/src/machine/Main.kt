fun main() {
    val machine = CoffeeMachine()

    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        val action = readln()

        when (action) {
            "buy" -> buy(machine)
            "fill" -> fill(machine)
            "take" -> take(machine)
            "remaining" -> machine.printState()
            "exit" -> return
        }
    }
}

class CoffeeMachine {
    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var disposableCups = 9
    var money = 550

    fun printState() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$coffeeBeans g of coffee beans")
        println("$disposableCups disposable cups")
        println("$$money of money")
    }

    fun sellCoffee(coffee: Coffee) {
        when {
            water < coffee.water -> {
                println("Sorry, not enough water!")
                return
            }

            milk < coffee.milk -> {
                println("Sorry, not enough milk!")
                return
            }

            coffeeBeans < coffee.coffeeBeans -> {
                println("Sorry, not enough coffeeBeans")
                return
            }

            disposableCups < 0 -> {
                println("Sorry, not enough disposableCups")
                return
            }

            else -> {
                println("I have enough resources, making you a coffee!")
                water -= coffee.water
                milk -= coffee.milk
                coffeeBeans -= coffee.coffeeBeans
                money += coffee.price
                disposableCups--
            }
        }
    }
}

fun take(machine: CoffeeMachine) {
    println("I gave you ${machine.money}")
    machine.money = 0
}

fun buy(machine: CoffeeMachine) {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
    val option = readln()
    machine.sellCoffee(
        when (option) {
            "1" -> Coffee.ESPRESSO
            "2" -> Coffee.LATTE
            "3" -> Coffee.CAPPUCCINO
            "back" -> return
            else -> throw IllegalArgumentException("Unexpected option")
        }
    )
}

fun fill(machine: CoffeeMachine) {
    println("Write how many ml of water you want to add:")
    machine.water += readln().toInt()
    println("Write how many ml of milk you want to add:")
    machine.milk += readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    machine.coffeeBeans += readln().toInt()
    println("Write how many disposable cups you want to add:")
    machine.disposableCups += readln().toInt()
}


enum class Coffee(val water: Int, val milk: Int, val coffeeBeans: Int, val price: Int) {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6),
}
