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
import com.example.medinfo.model.RxCuiResponse
import com.example.medinfo.model.InteractionResponse
import com.example.medinfo.model.FdaResponse
import com.example.medinfo.model.Medicine
import com.example.medinfo.model.MedicineDetails
import retrofit2.Call
import retrofit2.Callback
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
                val details = RetrofitInstance.api.getMedicineDetails(id)
                binding.medicineName.text = details.name
                binding.useCases.text = details.uses
                binding.ingredients.text = details.ingredients.joinToString(", ")
                binding.sideEffects.text = details.sideEffects.joinToString(", ")

                // Optionally, fetch drug interactions or warnings here
                val interactionsCall = RetrofitInstance.api.getDrugInteractions(id)
                interactionsCall.enqueue(object : Callback<InteractionResponse> {
                    override fun onResponse(call: Call<InteractionResponse>, response: Response<InteractionResponse>) {
                        if (response.isSuccessful) {
                            // Handle interactions response
                            Log.d("Interactions", "Interactions for $id: ${response.body()}")
                        }
                    }

                    override fun onFailure(call: Call<InteractionResponse>, t: Throwable) {
                        Log.e("Interactions", "API Error: ${t.message}")
                    }
                })
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}