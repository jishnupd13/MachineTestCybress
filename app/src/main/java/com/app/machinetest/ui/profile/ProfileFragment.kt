package com.app.machinetest.ui.profile

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.app.machinetest.R
import com.app.machinetest.databinding.FragmentProfileBinding
import com.app.machinetest.databinding.FragmentSplashScreenBinding
import com.app.machinetest.ui.splashscreen.SplashScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile),View.OnClickListener {

    private val binding: FragmentProfileBinding by viewBinding()
    private val viewModel: ProfileViewModel by viewModels()

    val args: ProfileFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listener = this
        binding.viewModel = viewModel
        binding.name = args.name
        binding.email = args.email
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.imageBack -> {
                findNavController().navigateUp()
            }
        }
    }
}