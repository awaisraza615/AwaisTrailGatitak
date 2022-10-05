package com.example.awaistrail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.awaistrail.data.Brand
import com.example.awaistrail.databinding.ItembrandingBinding

class BrandAdapter(
    private val mList: ArrayList<Brand>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItembrandingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ItemViewHolder(val binding: ItembrandingBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemViewHolder

        holder.binding.title.text = mList[position].name

        Glide.with(holder.binding.image.context).load(mList[position].logo).into(holder.binding.image)

    }

}