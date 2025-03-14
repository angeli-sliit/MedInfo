package com.example.medinfo.ui.reminder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medinfo.R
import com.example.medinfo.model.Reminder

class ReminderAdapter(
    private var reminders: List<Reminder>,
    private val onDeleteClick: (Reminder) -> Unit // Callback for delete action
) : RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder>() {

    // ViewHolder class
    class ReminderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val time: TextView = itemView.findViewById(R.id.reminder_time)
        val medicineName: TextView = itemView.findViewById(R.id.medicine_name)
        val dosage: TextView = itemView.findViewById(R.id.dosage) // Add dosage TextView
        val deleteButton: Button = itemView.findViewById(R.id.delete_button) // Delete button
    }

    // Inflate the item layout and create the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReminderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reminder, parent, false)
        return ReminderViewHolder(view)
    }

    // Bind data to the ViewHolder
    override fun onBindViewHolder(holder: ReminderViewHolder, position: Int) {
        val reminder = reminders[position]

        // Set data to views
        holder.time.text = reminder.time
        holder.medicineName.text = reminder.medicineName
        holder.dosage.text = reminder.dosage // Set dosage text

        // Set up delete button click listener
        holder.deleteButton.setOnClickListener {
            onDeleteClick(reminder) // Trigger the delete action
        }
    }

    // Return the number of items in the list
    override fun getItemCount(): Int {
        return reminders.size
    }

    // Update the list of reminders
    fun setReminders(newReminders: List<Reminder>) {
        reminders = newReminders
        notifyDataSetChanged() // Notify the adapter that data has changed
    }
}