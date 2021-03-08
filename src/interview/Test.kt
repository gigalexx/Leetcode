package interview

fun main() {

    val myClass = MyClass()

    myClass.click()
    myClass.showOff()


}


interface Clickable {
    var name: String

    fun click()
    fun showOff() {
        println("I'm clickable!")
    }

}


class MyClass : Clickable, MyAbstract("vasya") {


    override fun click() {
        println("They click on me!!")
    }

    override fun showOff() {
        TODO("Not yet implemented")
    }

}

abstract class MyAbstract(text: String) {

    var name = text
    abstract fun click()
    open fun showOff() {
        println("I'm clickable!")
    }
}