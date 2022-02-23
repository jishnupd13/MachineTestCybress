package com.app.machinetest.ui.users

import android.os.Bundle
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.app.machinetest.R
import com.app.machinetest.baseresult.BaseResult
import com.app.machinetest.databinding.FragmentUsersFragmentBinding
import com.app.machinetest.listeners.OnItemClickListener
import com.app.machinetest.models.response.Succes
import com.app.machinetest.ui.adapters.users.UsersAdapter
import com.app.machinetest.utils.hide
import com.app.machinetest.utils.show
import com.app.machinetest.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users_fragment), View.OnClickListener {

    private val binding: FragmentUsersFragmentBinding by viewBinding()
    private val viewModel: UserViewModel by viewModels()

    private lateinit var usersAdapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.listener = this
        initViews()
    }

    private fun initViews() {
        observeUserResponse()
        val listener = object : OnItemClickListener {
            override fun onItemClick(key: String, item: Any) {

                when (key) {
                    "itemClick" -> {
                        val data = item as Succes
                        findNavController().navigate(
                            UsersFragmentDirections.actionUsersFragmentToProfileFragment(
                                data.name?:"", data.email?:""
                            )
                        )
                    }
                }
            }

        }
        usersAdapter = UsersAdapter(listener)
        binding.recyclerViewUsers.adapter = usersAdapter
    }

    private fun observeUserResponse() {
        viewModel.userResponseLiveData.observe(viewLifecycleOwner, {

            when (it.status) {
                BaseResult.Status.SUCCESS -> {
                    binding.recyclerViewUsers.show()
                    binding.appLoader.hide()
                    if (it.data?.success?.size != 0) {
                        it.data?.success?.let { it1 -> usersAdapter.submitList(it1) }
                    }
                }

                BaseResult.Status.ERROR -> {
                    binding.recyclerViewUsers.hide()
                    binding.appLoader.hide()
                    Timber.e("error ${it.message}")
                    showToast(it.message ?: "")
                }

                BaseResult.Status.LOADING -> {
                    binding.recyclerViewUsers.hide()
                    binding.appLoader.show()
                }
            }
        })
    }

    override fun onClick(view: View?) {
        when (view) {
            binding.imageBack -> {
                findNavController().navigateUp()
            }
        }
    }


}