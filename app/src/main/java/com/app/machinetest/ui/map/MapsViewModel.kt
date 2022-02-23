package com.app.machinetest.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.machinetest.baseresult.BaseResult
import com.app.machinetest.baseresult.ResultWrapper
import com.app.machinetest.models.TestApiResponseModel
import com.app.machinetest.models.response.UserLocationModel
import com.app.machinetest.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel  @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel(){


    private val _response = MutableLiveData<BaseResult<UserLocationModel>>()
    val userResponseLiveData: LiveData<BaseResult<UserLocationModel>>
        get() = _response


    fun fetchUserResponse() = viewModelScope.launch {

        when (val response = mainRepository.fetchUserLocations()) {
            is ResultWrapper.Success ->
                _response.postValue(
                    BaseResult.success(
                        response.data
                    )
                )

            is ResultWrapper.Failure ->
                _response.postValue(
                    BaseResult.error(
                        response.message
                    )
                )

        }
    }


}