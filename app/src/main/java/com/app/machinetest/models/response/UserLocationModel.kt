package com.app.machinetest.models.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserLocationModel(
    @SerialName("location")
    val location: List<Location>?,
    @SerialName("success")
    val success: List<Succes>?
)