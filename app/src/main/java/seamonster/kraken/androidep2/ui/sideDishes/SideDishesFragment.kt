package seamonster.kraken.androidep2.ui.sideDishes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import seamonster.kraken.androidep2.R

class SideDishesFragment : Fragment() {

    companion object {
        fun newInstance() = SideDishesFragment()
    }

    private lateinit var viewModel: SideDishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_side_dishes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SideDishesViewModel::class.java]
    }

}