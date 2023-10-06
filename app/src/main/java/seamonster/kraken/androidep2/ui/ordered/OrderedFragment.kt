package seamonster.kraken.androidep2.ui.ordered

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
import seamonster.kraken.androidep2.databinding.FragmentOrderedBinding
import seamonster.kraken.androidep2.ui.ServedItemListener
import seamonster.kraken.androidep2.ui.ServedListAdapter

class OrderedFragment : Fragment() , ServedItemListener{
    private lateinit var binding: FragmentOrderedBinding

    companion object {
        fun newInstance() = OrderedFragment()
    }

    private lateinit var viewModel: OrderedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[OrderedViewModel::class.java]

        val navController = Navigation.findNavController(view)
        binding.buttonPrevPage.setOnClickListener {
            navController.navigateUp()
        }

        initRecyclerView()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.ordered.observe(viewLifecycleOwner) { data ->
            val adapter = binding.rvOrderedItems.adapter as ServedListAdapter
            adapter.data = data
            adapter.notifyDataSetChanged()
        }
    }

    private fun initRecyclerView() {
        val adapter = ServedListAdapter(listener = this)
        binding.rvOrderedItems.adapter = adapter
        binding.rvOrderedItems.layoutManager = LinearLayoutManager(context)
    }

    override fun onCheckedChange(item: Served) {
        // do nothing
    }
}