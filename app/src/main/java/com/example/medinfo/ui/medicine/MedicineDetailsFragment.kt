package com.example.medinfo.ui.medicine

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.medinfo.databinding.FragmentMedicineDetailsBinding
import com.example.medinfo.network.RetrofitInstance
import kotlinx.coroutines.launch
import com.example.medinfo.model.InteractionResponse
import com.example.medinfo.model.MedicineDetails
import retrofit2.Response

class MedicineDetailsFragment : Fragment() {

    private var medicineId: String? = null
    private var _binding: FragmentMedicineDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            medicineId = it.getString("medicineId")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMedicineDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        medicineId?.let { id ->
            fetchMedicineDetails(id)
        }
    }

    private fun fetchMedicineDetails(id: String) {
        lifecycleScope.launch {
            try {
                val response: Response<MedicineDetails> = RetrofitInstance.fdaApi.getMedicineDetails(id)
                if (response.isSuccessful) {
                    val details = response.body()
                    binding.medicineName.text = details?.name
                    binding.useCases.text = details?.uses
                    binding.sideEffects.text = details?.sideEffects?.joinToString(", ")
                } else {
                    Log.e("MedicineDetailsFragment", "Error fetching details: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                Log.e("MedicineDetailsFragment", "Error fetching medicine details: ${e.message}")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}