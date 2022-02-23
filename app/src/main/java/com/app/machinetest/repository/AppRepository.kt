package com.app.machinetest.repository

import com.app.machinetest.baseresult.safeApiCall
import com.app.machinetest.localdatabaseservice.AppLocalRoomDatabaseDao
import com.app.machinetest.localdatabaseservice.entities.StudentEntity
import com.app.machinetest.remoteservice.ApiHelper
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val apiHelper: ApiHelper,
    private val appLocalRoomDatabaseDao: AppLocalRoomDatabaseDao
) {

    suspend fun fetchUserLocations() = safeApiCall { apiHelper.fetchUserLocations() }
}