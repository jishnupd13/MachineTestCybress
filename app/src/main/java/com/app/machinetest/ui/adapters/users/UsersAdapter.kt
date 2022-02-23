package com.app.machinetest.ui.adapters.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.machinetest.R
import com.app.machinetest.databinding.ItemUsersBinding
import com.app.machinetest.listeners.OnItemClickListener
import com.app.machinetest.models.response.Succes

class UsersAdapter(val onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(binding: ItemUsersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemBinding = binding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: ItemUsersBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_users, parent, false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.itemBinding.apply {
            item = data
            listener = onItemClickListener
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private val differCallback = object : DiffUtil.ItemCallback<Succes>() {
        override fun areItemsTheSame(
            oldItem: Succes,
            newItem: Succes
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Succes,
            newItem: Succes
        ): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    fun submitList(list: List<Succes>) {
        differ.submitList(list)
    }

}