package com.app.machinetest.ui.parentactivity

import androidx.lifecycle.ViewModel
import com.app.machinetest.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ParentActivityViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {
}