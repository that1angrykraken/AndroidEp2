package seamonster.kraken.androidep2.ui.mainDishes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import seamonster.kraken.androidep2.R

class MainDishesFragment : Fragment() {

    companion object {
        fun newInstance() = MainDishesFragment()
    }

    private lateinit var viewModel: MainDishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_dishes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainDishesViewModel::class.java]
    }

}