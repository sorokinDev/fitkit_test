package ru.sorokin.dev.fitkittest.model.local.entiry

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "lessons")
class Lesson(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    val name: String,
    val description: String,
    val place: String,
    val teacher: String,
    val startTime: String,
    val endTime: String,
    val weekDay: Int,
    val appointmentId: String
)