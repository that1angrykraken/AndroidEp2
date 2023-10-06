package seamonster.kraken.androidep2.ui.sideDishes

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
import seamonster.kraken.androidep2.databinding.FragmentSideDishesBinding
import seamonster.kraken.androidep2.ui.ServedItemListener
import seamonster.kraken.androidep2.ui.ServedListAdapter

class SideDishesFragment : Fragment(), ServedItemListener {
    private lateinit var binding: FragmentSideDishesBinding

    companion object {
        fun newInstance() = SideDishesFragment()
    }

    private lateinit var viewModel: SideDishesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSideDishesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SideDishesViewModel::class.java]

        val navController = Navigation.findNavController(view)
        binding.buttonPrevPage.setOnClickListener {
            navController.navigateUp()
        }
        binding.buttonNextPage.setOnClickListener {
            navController.navigate(R.id.action_sideDishesFragment_to_dessertsFragment2)
        }

        initRecyclerView()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.sideDishes.observe(viewLifecycleOwner) { data ->
            val adapter = binding.rvSideDishes.adapter as ServedListAdapter
            adapter.data = data
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        val adapter = ServedListAdapter(listener = this)
        binding.rvSideDishes.adapter = adapter
        binding.rvSideDishes.layoutManager = LinearLayoutManager(context)
    }

    override fun onCheckedChange(item: Served) {
        viewModel.onItemCheckedChange(item)
    }
}