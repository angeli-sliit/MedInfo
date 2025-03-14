package com.example.medinfo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medinfo.R
import com.example.medinfo.model.Reminder
import com.example.medinfo.ui.reminder.ReminderAdapter
import com.example.medinfo.ui.reminder.ReminderViewModel
import com.example.medinfo.utils.HealthTips

class HomeFragment : Fragment() {

    private lateinit var reminderViewModel: ReminderViewModel
    private lateinit var adapter: ReminderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // RecyclerView setup for today's reminders
        val recyclerView = view.findViewById<RecyclerView>(R.id.reminders_section)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the adapter with an empty list and a lambda for delete action
        adapter = ReminderAdapter(emptyList()) { reminder ->
            // Handle the delete action here
            reminderViewModel.delete(reminder)
        }
        recyclerView.adapter = adapter

        // ViewModel setup
        reminderViewModel = ViewModelProvider(this).get(ReminderViewModel::class.java)
        reminderViewModel.allReminders.observe(viewLifecycleOwner, { reminders ->
            reminders?.let { adapter.setReminders(it) }
        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Display a random health tip
        val healthTipTextView = view.findViewById<TextView>(R.id.health_tip_text_view)
        healthTipTextView.text = HealthTips.getRandomTip()

        // Find the buttons
        val searchButton = view.findViewById<LinearLayout>(R.id.searchButton)
        val reminderButton = view.findViewById<LinearLayout>(R.id.reminderButton)
        val searchHistoryButton = view.findViewById<LinearLayout>(R.id.searchHistoryButton)
        val profileButton = view.findViewById<LinearLayout>(R.id.profileButton)

        // Set click listeners
        searchButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_search)
        }

        reminderButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_reminder)
        }

        searchHistoryButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_search)
        }

        profileButton.setOnClickListener {
            findNavController().navigate(R.id.navigation_profile)
        }
    }
}