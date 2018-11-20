package ru.sorokin.dev.fitkittest.model.converter

import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson
import ru.sorokin.dev.fitkittest.model.remote.entity.GroupLesson

object RemoteToLocal {
    fun lesson(remote: GroupLesson): Lesson {
        return Lesson(
                0,
                remote.name ?: "",
                remote.description  ?: "",
                remote.place ?: "",
                remote.teacher  ?: "",
                remote.startTime ?: "",
                remote.endTime ?: "",
                remote.weekDay ?: 0,
                remote.appointmentId ?: ""
        )
    }
}