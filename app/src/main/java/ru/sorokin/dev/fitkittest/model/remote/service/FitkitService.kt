package ru.sorokin.dev.fitkittest.model.remote.service

import retrofit2.Call
import retrofit2.http.GET
import ru.sorokin.dev.fitkittest.model.remote.entity.GroupLesson

interface FitkitService {

    companion object {
        const val BASE_URL = "https://sample.fitnesskit-admin.ru/"
    }

    @GET("schedule/get_group_lessons_v2/4/")
    fun getSchedule(): Call<List<GroupLesson>>

}