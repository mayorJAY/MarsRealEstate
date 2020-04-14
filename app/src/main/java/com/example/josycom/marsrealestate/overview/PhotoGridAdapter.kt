package com.example.josycom.marsrealestate.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.josycom.marsrealestate.databinding.GridViewItemBinding
import com.example.josycom.marsrealestate.network.MarsProperty
import com.example.josycom.marsrealestate.overview.PhotoGridAdapter.MarsPropertyViewHolder

class PhotoGridAdapter : ListAdapter<MarsProperty, MarsPropertyViewHolder>(DiffCallback) {
    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class MarsPropertyViewHolder(private var binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(marsProperty: MarsProperty) {
            binding.property = marsProperty
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPropertyViewHolder {
        return MarsPropertyViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.bind(marsProperty)
    }
}
