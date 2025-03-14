package com.example.medinfo.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.medinfo.databinding.FragmentSearchBinding
import com.example.medinfo.network.RetrofitInstance
import com.example.medinfo.model.Medicine
import kotlinx.coroutines.launch
import com.example.medinfo.model.RxCuiResponse
import com.example.medinfo.model.InteractionResponse
import com.example.medinfo.model.FdaResponse
import com.example.medinfo.model.MedicineDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            val query = binding.searchBar.text.toString()
            if (query.isNotEmpty()) {
                searchMedicine(query)
            }
        }
    }

    private fun searchMedicine(query: String) {
        lifecycleScope.launch {
            try {
                val medicines = RetrofitInstance.api.searchMedicine(query)
                if (medicines.isNotEmpty()) {
                    binding.searchResults.text = medicines.joinToString("\n") { it.name }
                } else {
                    binding.searchResults.text = "No results found."
                }
            } catch (e: Exception) {
                Log.e("SearchError", "Error searching medicine: ${e.message}")
                binding.searchResults.text = "An error occurred. Please try again."
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}