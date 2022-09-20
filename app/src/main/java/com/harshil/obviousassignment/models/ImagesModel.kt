package com.harshil.obviousassignment.models

import com.google.gson.annotations.SerializedName

//class ImagesModel : ArrayList<ImagesModel.ImagesModelItem>() {
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
    )
//}