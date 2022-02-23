package com.app.machinetest.ui.profile

import androidx.lifecycle.ViewModel
import com.app.machinetest.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel@Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {
}