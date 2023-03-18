package com.abit8.lovecalculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.abit8.lovecalculator.remote.LoveModel
import com.abit8.lovecalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    fun getLiveLove(firstname: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstname, secondName)
    }


}