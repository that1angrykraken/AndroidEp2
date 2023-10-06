package seamonster.kraken.androidep2.data

import androidx.lifecycle.MutableLiveData

val orderedItems = ArrayList<Served>()

val orderedData = MutableLiveData(orderedItems)

data class Served(val id: Int, val name: String, val type: Int, var checked: Boolean = false)

val sampleMainDishes = listOf(
    Served(1, "Steak", 0),
    Served(2, "Grilled Chicken", 0),
    Served(3, "Pasta Alfredo", 0),
    Served(4, "Eggs Fried Rice", 0),
    Served(5, "Pho", 0),
    Served(6, "Veggie Stir-Fry", 0),
    Served(7, "Roasted Lamb", 0),
    Served(8, "Shrimp Scampi", 0),
    Served(9, "Beef Stroganoff", 0),
    Served(10, "Teriyaki Salmon", 0)
)

val sampleSideDishes = listOf(
    Served(1, "French Fries", 1),
    Served(2, "Mashed Potatoes", 1),
    Served(3, "Garlic Bread", 1),
    Served(4, "Coleslaw", 1),
    Served(5, "Onion Rings", 1),
    Served(6, "Caesar Salad", 1),
    Served(7, "Steamed Vegetables", 1),
    Served(8, "Macaroni and Cheese", 1),
    Served(9, "Garlic Parmesan Wings", 1),
    Served(10, "Sweet Potato Fries", 1)
)

val sampleDesserts = listOf(
    Served(1, "Chocolate Cake", 2),
    Served(2, "Vanilla Ice Cream", 2),
    Served(3, "Fruit Salad", 2),
    Served(4, "Cheesecake", 2),
    Served(5, "Tiramisu", 2),
    Served(6, "Panna Cotta", 2),
    Served(7, "Creme Brulee", 2),
    Served(8, "Apple Pie", 2),
    Served(9, "Mango Sorbet", 2),
    Served(10, "Strawberry Shortcake", 2)
)

val sampleDrinks = listOf(
    Served(1, "Cappuccino", 3),
    Served(2, "Mojito", 3),
    Served(3, "Orange Juice", 3),
    Served(4, "Iced Tea", 3),
    Served(5, "Lemonade", 3),
    Served(6, "Hot Chocolate", 3),
    Served(7, "Mango Smoothie", 3),
    Served(8, "Green Tea", 3),
    Served(9, "Strawberry Milkshake", 3),
    Served(10, "Sparkling Water", 3)
)

