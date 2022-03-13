package com.ajc.time.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import com.ajc.time.model.remote.ResponseDTO
import com.ajc.time.model.remote.ResponseDTOItem
import com.ajc.time.model.remote.api.ApiService


class DataRepository(private val userApi: ApiService, private val dao: Dao) {

    private val userLiveData = MutableLiveData<ResponseDTOItem>()

    val user: LiveData<ResponseDTOItem> get() = userLiveData

    suspend fun getData(): ResponseDTO? {
        val result = userApi.getData(
            "vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com",
            "f07b41dff3msh8c0f57828abe5efp1afcbajsne81ed5e65b42"
        )
//        if (result?.body() != null) {
//            userLiveData.postValue(result.body())
//        }
        return result.body()
    }
}