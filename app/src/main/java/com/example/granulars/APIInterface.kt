package com.example.granulars

import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("api/v1/hdTDYhAyHmIePgddsjulYCYwKAD1PV8T/panelLayout/layout")
    fun getPanels() : Call<Panels>
}