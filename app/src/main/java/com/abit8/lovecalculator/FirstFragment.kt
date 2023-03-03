package com.abit8.lovecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abit8.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                LoveService().api.calculatePersentage(
                    firstName = firstnameEt.text.toString(),
                    secondName = secondnameEt.text.toString(),

                    ).enqueue(object : retrofit2.Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        if (response.isSuccessful) {
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf("result" to response.body())
                            )
                            //android.util.Log.e("asas", "onResponse: ${response.body()}")
                        }
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        //android.util.Log.e("asas", "onResponse: ${t.message}")
                    }

                })
            }
        }
    }

}