package com.example.feature_home.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entites.ResultEntities
import com.example.feature_home.databinding.ItemListHomeBinding

class HomeAdapter (private val data: List<ResultEntities>?)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding =
            ItemListHomeBinding.inflate(inflater, viewGroup,false)
        return HomeItemViewHolder(binding)
    }

    var onClickedLister: OnClickedListener? = null

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val dataList = data!![position]
        (holder as HomeAdapter.HomeItemViewHolder).bind(dataList)
        holder.setOnClickListener(View.OnClickListener {
            onClickedLister?.onItemClicked(
                dataList
            )
        })
    }

    override fun getItemCount(): Int = data?.size!!

    interface OnClickedListener {
        fun onItemClicked(data: ResultEntities)
    }

    inner class HomeItemViewHolder(val itemListBerandaBinding: ItemListHomeBinding) :
        RecyclerView.ViewHolder(itemListBerandaBinding.root) {

        fun bind(itemList: ResultEntities) {
            itemListBerandaBinding.tvCharacter.text = itemList.name
            itemListBerandaBinding.tvLocation.text = itemList.location.name
            itemListBerandaBinding.tvStatus.text = itemList.status
            itemListBerandaBinding.tvSpecies.text = itemList.species
            Glide.with(itemView)
                .load(itemList.image)
                .into(itemListBerandaBinding.ivCharacter)
        }

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }
}