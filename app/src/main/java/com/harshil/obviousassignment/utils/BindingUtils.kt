package com.harshil.obviousassignment.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.harshil.obviousassignment.R

object BindingUtils {

    @JvmStatic
    @BindingAdapter(value = ["imageUrl", "thumbnailSize"])
    fun AppCompatImageView.setImage(imageUrl: String, thumbnailSize: Float?) {
        this.run {
            Glide.with(context)
                .load(imageUrl)
                .thumbnail(thumbnailSize ?: 0.2f)
                .placeholder(R.drawable.ic_baseline_insert_photo_24)
                .error(R.drawable.ic_baseline_insert_photo_24)
                .into(this)
        }
    }

}