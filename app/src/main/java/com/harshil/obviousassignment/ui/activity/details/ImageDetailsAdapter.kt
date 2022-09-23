package com.harshil.obviousassignment.ui.activity.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.harshil.obviousassignment.R
import com.harshil.obviousassignment.databinding.ItemImageDetailsBinding
import com.harshil.obviousassignment.databinding.ItemImagesBinding
import com.harshil.obviousassignment.models.ImagesDiffUtils
import com.harshil.obviousassignment.models.ImagesModelItem

class ImageDetailsAdapter(
    private val images : MutableList<ImagesModelItem>,
) : RecyclerView.Adapter<ImageDetailsAdapter.AlbumsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumsViewHolder {
        val itemNotesBinding =
            DataBindingUtil.inflate<ItemImageDetailsBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_image_details, parent, false
            )
        return AlbumsViewHolder(itemNotesBinding)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.onBind(images[position], position)
    }

    override fun getItemCount() = images.size

    inner class AlbumsViewHolder(private val binding: ItemImageDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImagesModelItem, position: Int) {
            imageModel.let {
                binding.imageModel = imageModel
                binding.executePendingBindings()
            }
        }
    }
}