package seamonster.kraken.androidep2.ui.mainDishes

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import seamonster.kraken.androidep2.data.Served
import seamonster.kraken.androidep2.data.orderedData
import seamonster.kraken.androidep2.data.orderedItems
import seamonster.kraken.androidep2.data.sampleMainDishes

class MainDishesViewModel : ViewModel() {
    val mainDishes = MutableLiveData(sampleMainDishes)

    companion object {
        const val TAG = "MainDishesViewModel"
    }

    fun onItemCheckedChange(item: Served) {
        if (item.checked) addToOrder(item)
        else removeFromOrder(item)
        orderedData.value = orderedItems
    }

    private fun addToOrder(item: Served) {
        orderedItems.add(item)
        Log.d(TAG, "addToOrder: ok, orderedItems = ${orderedItems.size}")
    }

    private fun removeFromOrder(item: Served) {
        orderedItems.remove(item)
        Log.d(TAG, "removeFromOrder: ok, orderedItems = ${orderedItems.size}")
    }
}