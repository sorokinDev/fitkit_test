package ru.sorokin.dev.fitkittest.model.remote.entity

import com.google.gson.annotations.SerializedName


class TeacherV2 {

    @SerializedName("short_name")
    var shortName: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("position")
    var position: String? = null

    @SerializedName("imageUrl")
    var imageUrl: String? = null

}