package ru.sorokin.dev.fitkittest.ui.home

import android.arch.lifecycle.LiveData
import ru.sorokin.dev.fitkittest.model.DataResource
import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson
import ru.sorokin.dev.fitkittest.model.repository.ScheduleRepository
import ru.sorokin.dev.fitkittest.ui.base.BaseViewModel

class HomeViewModel(
        val scheduleRepository: ScheduleRepository
): BaseViewModel(){

    lateinit var scheduleLiveData: LiveData<DataResource<List<Lesson>>>

    fun getSchedule(): LiveData<DataResource<List<Lesson>>>{
        scheduleLiveData = scheduleRepository.getSchedule()
        return scheduleLiveData
    }
}