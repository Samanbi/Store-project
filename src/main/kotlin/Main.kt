import models.Person
import java.lang.NumberFormatException

fun main() {
    println("به فروشگاه خوش امدید")
    var totalSel: Long = 0
    var personList: MutableList<Person> = mutableListOf()

    try {
        while (true) {
            println("فروش کل فروشگاه: $totalSel تومان است. ")
            println("1 = واردکردن فروشنده")
            println("2 = فروشند برتر")
            println("3 = خرید")
            println("0 = خروج")

            val inMenu: Int = readln().toInt()
            when (inMenu) {
                1 -> totalSel = inputPerson(totalSel, personList)
                2 -> topPersons(personList)
                3 -> println("3")
                0 -> {
                    println("شما از فروشگاه خارج شدید")
                    return
                }else-> println("لطفا عدد مطابق منو را انتخواب کنید")
            }

        }
    } catch (e: NumberFormatException) {
        println("لطفا عدد مطابق منو را انتخواب کنید")
    } catch (e: IndexOutOfBoundsException) {
        println("لطفا عدد مطابق منو را انتخواب کنید")
    } catch (e: Exception) {
        println("در وارد کردن اطلاعات دقت فرمایید")
    }
}

private fun topPersons(personList: MutableList<Person>) {
    val topPerson = personList.sortedByDescending { it.totalPrice }
    for (person in topPerson) {
        println("${person.name} - ${person.totalPrice} - ${person.levelPerson}")
    }
}

private fun inputPerson(totalSel: Long, personList: MutableList<Person>): Long {
    var totalSel1 = totalSel
    var totalPrice: Long = 0
    println("خوش امدید لطفا نام خود را وارد کنید")
    val personName: String = readln()
    println("تعداد ایتم های فروخته شده خود را وارد کنید")
    val itemCount: Short = readln().toShort()

    for (item in 1..itemCount) {
        println("قیمت ایتم $item را وارد کنید")
        val itemPrice = readln().toLong()
        totalPrice += itemPrice
    }
    totalSel1 += totalPrice
    val person = Person(personName, itemCount, totalPrice)
    personList.add(person)
    println(person.name)
    println(person.levelPerson)
    println(person.itemCont)
    println(person.totalPrice)
    return totalSel1
}
