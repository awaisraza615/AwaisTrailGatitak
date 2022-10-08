package com.example.awaistrail.ui.dashboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.awaistrail.ui.dashboard.data.Categories
import com.example.awaistrail.databinding.ItemcategoryBinding


class CategoryAdapter(
    private val mList: ArrayList<Categories>,

    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemcategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ItemViewHolder(val binding: ItemcategoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ItemViewHolder
        holder.binding.title.text = mList[position].name

    }

}