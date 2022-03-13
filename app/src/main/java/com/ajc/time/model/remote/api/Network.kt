package com.ajc.time.model.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://newsapi.org/v2/everything?q=india?apiKey=b5becfb5a3d34c7991cb1af2c22c0d57

//https://tasty.p.rapidapi.com/recipes/list?from=0&size=20

//https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/api/covid-ovid-data/sixmonth/IND


class Network {
    companion object {
        private const val BaseUrl = "https://vaccovid-coronavirus-vaccine-and-treatment-tracker.p.rapidapi.com/"
        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}