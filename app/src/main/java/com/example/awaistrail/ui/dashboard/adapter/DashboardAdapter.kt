package com.example.awaistrail.ui.dashboard.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.awaistrail.databinding.ItembannerlargeBinding
import com.example.awaistrail.databinding.ItembannersmallBinding
import com.example.awaistrail.databinding.ItembrandBinding
import com.example.awaistrail.databinding.ItemcategoriesBinding
import com.example.awaistrail.ui.dashboard.data.*
import com.example.awaistrail.utils.Constants.BANNER_LARGE
import com.example.awaistrail.utils.Constants.BANNER_SMALL
import com.example.awaistrail.utils.Constants.BRAND
import com.example.awaistrail.utils.Constants.CATEGORIES
import com.example.awaistrail.utils.Helper.isValidHexaCode
import com.example.awaistrail.utils.Helper.jsonToAny


class DashboardAdapter(private val mList: ArrayList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            BANNER_SMALL -> {
                val bindingSmall =
                    ItembannersmallBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ItemSmall(bindingSmall)
            }
            BANNER_LARGE -> {
                val bindingLarge =
                    ItembannerlargeBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ItemLarge(bindingLarge)
            }
            CATEGORIES -> {
                val bindingCategories =
                    ItemcategoriesBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                return ItemCategories(bindingCategories)
            }
            else -> {
                val bindingBrand =
                    ItembrandBinding.inflate(LayoutInflater.from(parent.context),
                        parent, false)
                return ItemBrand(bindingBrand)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ItemBrand(val bindingBrand: ItembrandBinding) : RecyclerView.ViewHolder(bindingBrand.root)
    class ItemCategories(val bindingCategories: ItemcategoriesBinding) : RecyclerView.ViewHolder(bindingCategories.root)
    class ItemSmall(val bindingSmall: ItembannersmallBinding) : RecyclerView.ViewHolder(bindingSmall.root)
    class ItemLarge(val bindingLarge: ItembannerlargeBinding) : RecyclerView.ViewHolder(bindingLarge.root)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            BRAND -> {
                holder as ItemBrand
                if (mList[position].isSeeAllShown == false) {
                    holder.bindingBrand.seeall.visibility = View.GONE
                }


                if (isValidHexaCode(mList[position].backgroundColor)) {
                    holder.bindingBrand.mainBg.setBackgroundColor(Color.parseColor(mList[position].backgroundColor))
                }


                val items =
                    (jsonToAny(mList[position].items, Brand::class.java)) as ArrayList<Brand>
                holder.bindingBrand.title.text = mList[position].title

                val brandAdapter = BrandAdapter(items)
                holder.bindingBrand.recyclerView.adapter = brandAdapter
            }
            BANNER_SMALL -> {
                holder as ItemSmall

                val item =
                    jsonToAny(
                        mList[position].items,
                        BannerSmall::class.java
                    ) as BannerSmall

                Glide.with(holder.bindingSmall.image.context).load(item.image)
                    .into(holder.bindingSmall.image)
            }
            BANNER_LARGE -> {
                holder as ItemLarge

                val item = (jsonToAny(
                    mList[position].items,
                    BannerLarge::class.java
                ) as BannerLarge)
                Glide.with(holder.bindingLarge.image.context).load(item.image)
                    .into(holder.bindingLarge.image)

            }
            CATEGORIES -> {
                holder as ItemCategories
                holder.bindingCategories.title.text = mList[position].title

                if (mList[position].isSeeAllShown == false) {
                    holder.bindingCategories.seeall.visibility = View.GONE
                }

                val item = (jsonToAny(
                    mList[position].items,
                    Categories::class.java
                ) as ArrayList<Categories>)

                val categoriesAdapter = CategoryAdapter(item)
                holder.bindingCategories.recyclerView.adapter = categoriesAdapter
            }
        }


    }

    override fun getItemViewType(position: Int): Int {
        return when (mList.get(position).type) {
            "banner_small" -> BANNER_SMALL
            "banner_large" -> BANNER_LARGE
            "category" -> CATEGORIES
            else -> BRAND
        }
    }

}