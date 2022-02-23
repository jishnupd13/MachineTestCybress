package com.app.machinetest.ui.home

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.machinetest.R
import com.app.machinetest.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener {

    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.listener = this
    }

    override fun onClick(view: View?) {

        when (view) {
            binding.layoutMapTask -> {
                findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToMapsFragment())

            }

            binding.layoutUserTask->{
                findNavController().navigate(HomeFragmentDirections.actionHomeFragment2ToUsersFragment())
            }
        }
    }
}