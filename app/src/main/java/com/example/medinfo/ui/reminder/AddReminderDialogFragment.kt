import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.medinfo.R
import com.example.medinfo.model.Reminder
import com.example.medinfo.ui.reminder.ReminderViewModel

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
                val medicineNameText = medicineName.text.toString()
                val timeText = time.text.toString()
                val dosageText = dosage.text.toString()

                // Validation
                if (medicineNameText.isEmpty() || timeText.isEmpty() || dosageText.isEmpty()) {
                    // Show error message
                    Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                } else if (!isValidTimeFormat(timeText)) {
                    // Show error message for invalid time format
                    Toast.makeText(requireContext(), "Please enter a valid time (HH:mm)", Toast.LENGTH_SHORT).show()
                } else if (!isNumeric(dosageText)) {
                    // Show error message for invalid dosage
                    Toast.makeText(requireContext(), "Dosage must be a number", Toast.LENGTH_SHORT).show()
                } else {
                    val reminder = Reminder(
                        medicineName = medicineNameText,
                        time = timeText,
                        dosage = dosageText
                    )
                    viewModel.insert(reminder) // Use the ViewModel to insert the reminder
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }

        return builder.create()
    }

    // Function to validate time format (HH:mm)
    private fun isValidTimeFormat(time: String): Boolean {
        val timePattern = "^([01]?[0-9]|2[0-3]).[0-5][0-9]$" // Regex for HH:mm format
        return time.matches(timePattern.toRegex())
    }

    // Function to check if a string is numeric
    private fun isNumeric(str: String): Boolean {
        return str.all { it.isDigit() }
    }
}