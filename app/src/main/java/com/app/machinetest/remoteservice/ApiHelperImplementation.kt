package com.app.machinetest.remoteservice

import com.app.machinetest.models.TestApiResponseModel
import com.app.machinetest.models.response.UserLocationModel
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImplementation @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun fetchUserLocations(): Response<UserLocationModel> = apiService.fetchUserLocations()
}