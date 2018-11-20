package ru.sorokin.dev.fitkittest.model.repository

import android.arch.lifecycle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.sorokin.dev.fitkittest.model.DataResource
import ru.sorokin.dev.fitkittest.model.Error
import ru.sorokin.dev.fitkittest.model.Success
import ru.sorokin.dev.fitkittest.model.converter.RemoteToLocal
import ru.sorokin.dev.fitkittest.model.local.dao.LessonDao
import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson
import ru.sorokin.dev.fitkittest.model.remote.entity.GroupLesson
import ru.sorokin.dev.fitkittest.model.remote.service.FitkitService
import ru.sorokin.dev.fitkittest.util.ioThread

class ScheduleRepository(
        val fitkitService: FitkitService,
        val lessonDao: LessonDao
) {

    fun getSchedule(): LiveData<DataResource<List<Lesson>>> {
        val res = MediatorLiveData<DataResource<List<Lesson>>>()
        var isFirstTime = true

        res.addSource(lessonDao.selectAll()) {
            res.value = Success(it ?: listOf())
            if(isFirstTime){
                isFirstTime = false
                fitkitService.getSchedule().enqueue(object : Callback<List<GroupLesson>> {
                    override fun onFailure(call: Call<List<GroupLesson>>, t: Throwable) {
                        res.value = Error(res.value?.data ?: listOf(), t)
                    }

                    override fun onResponse(call: Call<List<GroupLesson>>, response: Response<List<GroupLesson>>) {
                        if(response.isSuccessful){
                            ioThread { lessonDao.clear() }
                            ioThread { lessonDao.insertOrUpdateAll(response.body()?.map { RemoteToLocal.lesson(it) }!!) }
                        }
                    }

                })
            }
        }


        return res
    }

}