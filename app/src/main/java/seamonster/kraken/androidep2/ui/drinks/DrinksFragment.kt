package seamonster.kraken.androidep2.ui.drinks

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
import seamonster.kraken.androidep2.databinding.FragmentDrinksBinding
import seamonster.kraken.androidep2.ui.ServedItemListener
import seamonster.kraken.androidep2.ui.ServedListAdapter

class DrinksFragment : Fragment(), ServedItemListener {
    private lateinit var binding: FragmentDrinksBinding

    companion object {
        fun newInstance() = DrinksFragment()
    }

    private lateinit var viewModel: DrinksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[DrinksViewModel::class.java]

        val navController = Navigation.findNavController(view)
        binding.buttonPrevPage.setOnClickListener {
            navController.navigateUp()
        }
        binding.buttonNextPage.setOnClickListener {
            navController.navigate(R.id.action_drinksFragment_to_orderedFragment)
        }

        initRecyclerView()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.drinks.observe(viewLifecycleOwner) { data ->
            val adapter = binding.rvDrinks.adapter as ServedListAdapter
            adapter.data = data
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        val adapter = ServedListAdapter(listener = this)
        binding.rvDrinks.adapter = adapter
        binding.rvDrinks.layoutManager = LinearLayoutManager(context)
    }

    override fun onCheckedChange(item: Served) {
        viewModel.onItemCheckedChange(item)
    }
}