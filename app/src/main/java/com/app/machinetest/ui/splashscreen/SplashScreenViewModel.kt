package com.app.machinetest.ui.splashscreen

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.app.machinetest.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val mainRepository: AppRepository
) : ViewModel() {
}