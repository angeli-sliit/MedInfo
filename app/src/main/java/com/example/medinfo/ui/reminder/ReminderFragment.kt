package com.example.medinfo.ui.reminder

import AddReminderDialogFragment
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medinfo.R
import com.example.medinfo.model.Reminder

class ReminderFragment : Fragment() {

    private lateinit var reminderViewModel: ReminderViewModel
    private lateinit var adapter: ReminderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reminder, container, false)

        // RecyclerView setup
        val recyclerView = view.findViewById<RecyclerView>(R.id.reminder_list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ReminderAdapter(emptyList()) { reminder -> showDeleteConfirmationDialog(reminder) }
        recyclerView.adapter = adapter

        // ViewModel setup
        reminderViewModel = ViewModelProvider(this).get(ReminderViewModel::class.java)
        reminderViewModel.allReminders.observe(viewLifecycleOwner, { reminders ->
            reminders?.let { adapter.setReminders(it) }
        })

        // Add Reminder Button
        view.findViewById<View>(R.id.add_reminder_button).setOnClickListener {
            showAddReminderDialog()
        }

        return view
    }

    private fun showDeleteConfirmationDialog(reminder: Reminder) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Reminder")
            .setMessage("Are you sure you want to delete this reminder?")
            .setPositiveButton("Yes") { _, _ ->
                deleteReminder(reminder)
            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }

    private fun deleteReminder(reminder: Reminder) {
        reminderViewModel.delete(reminder) // Call the delete method in ViewModel
    }

    private fun showAddReminderDialog() {
        val dialog = AddReminderDialogFragment()
        dialog.show(parentFragmentManager, "AddReminderDialogFragment")
    }
}