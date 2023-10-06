package seamonster.kraken.androidep2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import seamonster.kraken.androidep2.data.Served
import seamonster.kraken.androidep2.databinding.LayoutListItemBinding

class ServedListAdapter(
    var data: List<Served> = ArrayList(),
    private val listener: ServedItemListener,
) :
    RecyclerView.Adapter<ServedListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: LayoutListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Served, listener: ServedItemListener) {
            binding.cbServedItemChecked.run {
                isChecked = item.checked
                text = item.name
                setOnClickListener { view ->
                    val cb = view as MaterialCheckBox
                    item.checked = cb.isChecked
                    listener.onCheckedChange(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[holder.adapterPosition]
        holder.bind(item, listener)
    }
}