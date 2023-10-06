package seamonster.kraken.androidep2.ui.desserts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import seamonster.kraken.androidep2.R
import seamonster.kraken.androidep2.data.Served
import seamonster.kraken.androidep2.databinding.FragmentDessertsBinding
import seamonster.kraken.androidep2.ui.ServedItemListener
import seamonster.kraken.androidep2.ui.ServedListAdapter

class DessertsFragment : Fragment(), ServedItemListener {
    private lateinit var binding: FragmentDessertsBinding

    companion object {
        fun newInstance() = DessertsFragment()
    }

    private lateinit var viewModel: DessertsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDessertsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DessertsViewModel::class.java]

        val navController = Navigation.findNavController(view)
        binding.buttonPrevPage.setOnClickListener {
            navController.navigateUp()
        }
        binding.buttonNextPage.setOnClickListener {
            navController.navigate(R.id.action_dessertsFragment2_to_drinksFragment)
        }

        initRecyclerView()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.desserts.observe(viewLifecycleOwner) { data ->
            val adapter = binding.rvDesserts.adapter as ServedListAdapter
            adapter.data = data
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        val adapter = ServedListAdapter(listener = this)
        binding.rvDesserts.adapter = adapter
        binding.rvDesserts.layoutManager = LinearLayoutManager(context)
    }

    override fun onCheckedChange(item: Served) {
        viewModel.onItemCheckedChange(item)
    }
}