class MobilePhone(osName: String, brand: String, model: String) {
    var battery = 50

    init {
        println("The phone $model from $brand uses $osName as its Operating System")
    }

    fun chargeBattery() {
        println("The battery had $battery% and now it have ${battery + 30}%")
        battery += 30
    }

}


fun main() {

    val phone = MobilePhone(osName = "Android", brand = "Samsung", model = "Note 20 Plus")

    phone.chargeBattery()


}

interface Mammal {
    val name: String

    fun canDrive() {
        print("Yes i can by $name")
    }

    class Nested {

        val names = "Vasya"

        init {
            print(names)

        }
    }
}

class Me(override val name: String) : Mammal