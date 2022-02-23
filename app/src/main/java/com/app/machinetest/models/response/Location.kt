package com.app.machinetest.models.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("lat")
    val lat: String?,
    @SerialName("long")
    val long: String?
)