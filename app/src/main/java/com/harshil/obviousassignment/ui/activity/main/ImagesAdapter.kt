package com.harshil.obviousassignment.ui.activity.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.harshil.obviousassignment.R
import com.harshil.obviousassignment.databinding.ItemImagesBinding
import com.harshil.obviousassignment.models.ImagesDiffUtils
import com.harshil.obviousassignment.models.ImagesModelItem

class ImagesAdapter(
    private val itemClick: (position: Int, action: String) -> Unit = { _: Int, _: String -> }
) : RecyclerView.Adapter<ImagesAdapter.AlbumsViewHolder>() {

    private var images = mutableListOf<ImagesModelItem>()
        set(value) {
            val diffResult = DiffUtil.calculateDiff(ImagesDiffUtils(images, value))
            field = value
            diffResult.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlbumsViewHolder {
        val itemNotesBinding =
            DataBindingUtil.inflate<ItemImagesBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_images, parent, false
            )
        return AlbumsViewHolder(itemNotesBinding)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        holder.onBind(images[position], position)
    }

    override fun getItemCount() = images.size

    inner class AlbumsViewHolder(private val binding: ItemImagesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(imageModel: ImagesModelItem, position: Int) {
            imageModel.let {
                binding.imageModel = imageModel
                binding.executePendingBindings()

                binding.root.setOnClickListener {
                    itemClick(position, "open")
                }
            }
        }
    }

    fun setImagesList(_images: MutableList<ImagesModelItem>) {
        images = _images
    }
}