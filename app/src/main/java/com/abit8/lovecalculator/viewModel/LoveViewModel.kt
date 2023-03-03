package com.abit8.lovecalculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.abit8.lovecalculator.remote.LoveModel
import com.abit8.lovecalculator.repository.Repository

class LoveViewModel : ViewModel() {

    private val repository = Repository()
    fun getLiveLove(firstname: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstname, secondName)
    }
}