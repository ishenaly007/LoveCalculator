package com.abit8.lovecalculator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.abit8.lovecalculator.databinding.FragmentFirstBinding
import com.abit8.lovecalculator.viewModel.LoveViewModel


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()
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
                viewModel.getLiveLove(
                    firstname = firstnameEt.text.toString(),
                    secondName = secondnameEt.text.toString()
                ).observe(viewLifecycleOwner,
                    Observer { LoveModel ->
                        Log.e("asas", "initClicker: $LoveModel")
                    })
            }
        }
    }

}