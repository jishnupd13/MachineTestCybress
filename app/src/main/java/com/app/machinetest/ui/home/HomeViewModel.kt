package com.app.machinetest.ui.home

import androidx.lifecycle.ViewModel
import com.app.machinetest.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {
}