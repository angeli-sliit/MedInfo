package com.example.medinfo.ui.reminder

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.medinfo.R
import com.example.medinfo.model.Reminder

class AddReminderDialogFragment : DialogFragment() {

    private lateinit var viewModel: ReminderViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_add_reminder, null)

        val medicineName = view.findViewById<EditText>(R.id.medicine_name)
        val time = view.findViewById<EditText>(R.id.reminder_time)
        val dosage = view.findViewById<EditText>(R.id.dosage)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(ReminderViewModel::class.java)

        builder.setView(view)
            .setTitle("Add Reminder")
            .setPositiveButton("Add") { _, _ ->
                val reminder = Reminder(
                    medicineName = medicineName.text.toString(),
                    time = time.text.toString(),
                    dosage = dosage.text.toString()
                )
                viewModel.insert(reminder) // Use the ViewModel to insert the reminder
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

        return builder.create()
    }
}