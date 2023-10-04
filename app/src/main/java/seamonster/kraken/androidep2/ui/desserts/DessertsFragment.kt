package seamonster.kraken.androidep2.ui.desserts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import seamonster.kraken.androidep2.R

class DessertsFragment : Fragment() {

    companion object {
        fun newInstance() = DessertsFragment()
    }

    private lateinit var viewModel: DessertsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_desserts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DessertsViewModel::class.java]
    }

}