package ru.sorokin.dev.fitkittest.model.remote.entity

import com.google.gson.annotations.SerializedName

class GroupLesson {

    @SerializedName("name")
    var name: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("place")
    var place: String? = null

    @SerializedName("teacher")
    var teacher: String? = null

    @SerializedName("startTime")
    var startTime: String? = null

    @SerializedName("endTime")
    var endTime: String? = null

    @SerializedName("weekDay")
    var weekDay: Int? = null

    @SerializedName("appointment_id")
    var appointmentId: String? = null

    @SerializedName("service_id")
    var serviceId: String? = null

    @SerializedName("pay")
    var pay: Boolean? = null

    @SerializedName("appointment")
    var appointment: Boolean? = null

    @SerializedName("teacher_v2")
    var teacherV2: TeacherV2? = null

    @SerializedName("color")
    var color: String? = null

    @SerializedName("availability")
    var availability: Int? = null
}