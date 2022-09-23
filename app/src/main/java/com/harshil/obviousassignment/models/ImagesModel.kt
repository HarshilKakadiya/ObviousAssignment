package com.harshil.obviousassignment.models

import android.os.Parcel
import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class ImagesModelItem(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val hdurl: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val serviceVersion: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(copyright)
        parcel.writeString(date)
        parcel.writeString(explanation)
        parcel.writeString(hdurl)
        parcel.writeString(mediaType)
        parcel.writeString(serviceVersion)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ImagesModelItem> {
        override fun createFromParcel(parcel: Parcel): ImagesModelItem {
            return ImagesModelItem(parcel)
        }

        override fun newArray(size: Int): Array<ImagesModelItem?> {
            return arrayOfNulls(size)
        }
    }
}


class ImagesDiffUtils(
    private val oldList: MutableList<ImagesModelItem>?,
    private val newList: MutableList<ImagesModelItem>?
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList?.get(newItemPosition)?.hdurl?.equals(oldList?.get(oldItemPosition)?.hdurl)!! &&
                (newList[newItemPosition].url == oldList?.get(oldItemPosition)?.url)
    }

    override fun getOldListSize(): Int {
        return oldList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newList?.size ?: 0
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return newList?.get(newItemPosition)?.equals(oldList?.get(oldItemPosition))!!
    }

}