package com.ajc.time.model.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

//https://newsapi.org/v2/everything?q=india?apiKey=b5becfb5a3d34c7991cb1af2c22c0d57

//https://tasty.p.rapidapi.com/recipes/list?from=0&size=20

//https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/covid-ovid-data/sixmonth/IND

interface ApiService {
    @GET("api/covid-ovid-data/sixmonth/IND")
    suspend fun getData(
        @Header("x-rapidapi-host") token: String,
        @Header("x-rapidapi-key") token1: String

    ): Response<com.ajc.time.model.remote.ResponseDTOItem>
}