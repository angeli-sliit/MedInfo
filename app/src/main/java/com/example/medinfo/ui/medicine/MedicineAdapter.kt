package com.example.medinfo.ui.medicine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.medinfo.model.Medicine
import com.example.medinfo.R

class MedicineAdapter(
    private val onClick: (Medicine) -> Unit
) : ListAdapter<Medicine, MedicineAdapter.ViewHolder>(DiffCallback) {

    // Add 'inner' keyword here
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.medicine_name)

        fun bind(medicine: Medicine) {
            nameTextView.text = medicine.name
            itemView.setOnClickListener {
                onClick(medicine)  // Now accessible
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medicine, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Medicine>() {
        override fun areItemsTheSame(oldItem: Medicine, newItem: Medicine) =
            oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: Medicine, newItem: Medicine) =
            oldItem == newItem
    }
}