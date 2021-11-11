package com.example.granulars

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface APIInterface {

    @GET("api/v1/hdTDYhAyHmIePgddsjulYCYwKAD1PV8T/panelLayout/layout")
    fun getPanels() : Call<Panels>

    @PUT("api/v1/hdTDYhAyHmIePgddsjulYCYwKAD1PV8T/effects")
    fun animate(@Body write: Write): Call<Write>
}