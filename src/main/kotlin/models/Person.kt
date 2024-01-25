package models

class Person(var name: String, var itemCont: Short, var itemPrice: Long) {
    var totalPrice: Long = 0
    var levelPerson: String? = null

    init {
        totalPrice += itemPrice
        setLevelPerson(totalPrice)
    }

    private fun setLevelPerson(price: Long) {
        if (price <= 5000000)
            levelPerson = "فروشنده ضعیف"
        else if (price in 5000000..10000000)
            levelPerson = "فروشنده متوسط"
        else if (price > 10000001)
            levelPerson = "فروشنده قوی"
    }
}