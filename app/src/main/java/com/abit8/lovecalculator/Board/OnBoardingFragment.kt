package com.abit8.lovecalculator.Board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.abit8.lovecalculator.Pref.Pref
import com.abit8.lovecalculator.R
import com.abit8.lovecalculator.databinding.FragmentOnBoardingBinding

import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment: Fragment() {
    private lateinit var onBoardAdapter: OnBoardAdapter
    private lateinit var binding: FragmentOnBoardingBinding
    @Inject
    lateinit var pref: Pref



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())

        if (pref.isUserSeen()){
            findNavController().navigate(R.id.mainFragment)
        }
        val onBoardAdapter1 = OnBoardAdapter(this::onClick)
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.pager
        viewPager.adapter = onBoardAdapter1
        dotsIndicator.attachTo(viewPager)
        viewPager.adapter = onBoardAdapter1
        binding.pager.adapter = onBoardAdapter1

}
    fun onClick(){
        findNavController().navigateUp()
        pref.userSeen()
    }
}