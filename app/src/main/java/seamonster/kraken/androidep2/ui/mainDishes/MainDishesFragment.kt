package seamonster.kraken.androidep2.ui.mainDishes

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
import seamonster.kraken.androidep2.databinding.FragmentMainDishesBinding
import seamonster.kraken.androidep2.ui.ServedItemListener
import seamonster.kraken.androidep2.ui.ServedListAdapter

class MainDishesFragment : Fragment(), ServedItemListener {
    private lateinit var binding: FragmentMainDishesBinding

    companion object {
        fun newInstance() = MainDishesFragment()
    }

    private lateinit var viewModel: MainDishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainDishesBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainDishesViewModel::class.java]

        val navController = Navigation.findNavController(view)
        binding.buttonNextPage.setOnClickListener {
            navController.navigate(R.id.action_mainDishesFragment_to_sideDishesFragment)
        }

        initRecyclerView()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.mainDishes.observe(viewLifecycleOwner) { data ->
            val adapter = binding.rvMainDishes.adapter as ServedListAdapter
            adapter.data = data
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        val adapter = ServedListAdapter(listener = this)
        binding.rvMainDishes.adapter = adapter
        binding.rvMainDishes.layoutManager = LinearLayoutManager(context)
    }

    override fun onCheckedChange(item: Served) {
        viewModel.onItemCheckedChange(item)
    }

}