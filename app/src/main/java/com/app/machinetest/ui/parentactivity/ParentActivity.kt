package com.app.machinetest.ui.parentactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.viewbinding.library.activity.viewBinding
import androidx.activity.viewModels
import com.app.machinetest.databinding.ActivityParentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentActivity : AppCompatActivity(),View.OnClickListener {

    private val binding: ActivityParentBinding by viewBinding()
    private val viewModel: ParentActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.listener = this
    }

    override fun onClick(view: View?) {

    }


}