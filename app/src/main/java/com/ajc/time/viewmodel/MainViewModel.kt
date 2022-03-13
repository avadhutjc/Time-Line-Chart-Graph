package com.ajc.time.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajc.time.model.remote.ResponseDTOItem
import com.ajc.time.repository.DataRepository
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val dataRepository: DataRepository) : ViewModel() {

    fun createTransaction() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = dataRepository.getData()

            val entryList = ArrayList<Entry>()

            result?.let {
                it.forEach{

                    val date = it.date.toString().length - 2
                    val dateInFloat = date.
                    val totalCase = it.totalCases?.toFloat()
                    if (date != null &&  totalCase != null) {
                        val entry = Entry(date)
                    }

                }
            }

        }
    }

    val user: LiveData<ResponseDTOItem> get() = dataRepository.user
    var userData = MutableLiveData<List<Entry>>()


}