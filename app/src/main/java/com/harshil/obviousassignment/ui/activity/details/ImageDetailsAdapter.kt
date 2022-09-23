package com.harshil.obviousassignment.ui.activity.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.harshil.obviousassignment.R
import com.harshil.obviousassignment.databinding.ItemImageDetailsBinding
import com.harshil.obviousassignment.models.ImagesModelItem

class ImageDetailsAdapter(
    private val images : MutableList<ImagesModelItem>,
) : RecyclerView.Adapter<ImageDetailsAdapter.ImageDetailsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ImageDetailsViewHolder {
        val itemNotesBinding =
            DataBindingUtil.inflate<ItemImageDetailsBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_image_details, parent, false
            )
        return ImageDetailsViewHolder(itemNotesBinding)
    }

    override fun onBindViewHolder(holder: ImageDetailsViewHolder, position: Int) {
        holder.onBind(images[position], position)
    }

    override fun getItemCount() = images.size

    inner class ImageDetailsViewHolder(private val binding: ItemImageDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImagesModelItem, position: Int) {
            imageModel.let {
                binding.imageModel = imageModel
                binding.executePendingBindings()
            }
        }
    }
}