package com.app.machinetest.remoteservice

import com.app.machinetest.models.TestApiResponseModel
import com.app.machinetest.models.response.UserLocationModel
import retrofit2.Response

interface ApiHelper {
    suspend fun fetchUserLocations(): Response<UserLocationModel>

}