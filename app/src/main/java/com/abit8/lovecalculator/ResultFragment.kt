package com.abit8.lovecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abit8.lovecalculator.databinding.FragmentResultBinding
import com.abit8.lovecalculator.remote.LoveModel


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val result = arguments?.getSerializable("result") as LoveModel
        with(binding){
            name1.text = result.firstName.toString()
            name2.text = result.secondName.toString()
            persentage.text = result.percentage.toString() + "%"
            resultTv.text = result.result.toString()
        }
    }


}