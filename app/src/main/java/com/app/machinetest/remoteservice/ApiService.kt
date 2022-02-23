package com.app.machinetest.remoteservice

import com.app.machinetest.models.TestApiResponseModel
import com.app.machinetest.models.response.UserLocationModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("hrportal/public/tracking/viewreport")
    suspend fun fetchUserLocations():Response<UserLocationModel>
}