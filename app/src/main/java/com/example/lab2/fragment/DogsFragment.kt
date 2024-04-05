package com.example.lab2.fragment

import com.example.lab2.adapter.DogsAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.FragmentDogsBinding
import com.example.lab2.model.entity.Dog
import com.example.lab2.model.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogsFragment : Fragment() {
    private var _binding: FragmentDogsBinding? = null
    private val binding get() = _binding!!
    private val adapter = DogsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDogsBinding.inflate(
            inflater,
            container,
            false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.searchBar.setOnEditorActionListener{ it, actionId, _ ->
            if(actionId == android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH){
                ApiClient.instance.getDog(it.text.toString()).enqueue(object : Callback<List<Dog>>{
                    override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {
                        if (response.isSuccessful) {
                            response.body()?.let { it1 -> adapter.setItems(it1) }
                        }
                        else {
                            Log.e("response", response.errorBody().toString())
                        }
                    }
                    override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                        Log.e("response", t.message.toString())
                    }})
                true }
            else
                false }}
}