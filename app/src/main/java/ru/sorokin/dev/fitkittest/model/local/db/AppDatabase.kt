package ru.sorokin.dev.fitkittest.model.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ru.sorokin.dev.fitkittest.model.local.dao.LessonDao
import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson

@Database(entities = [Lesson::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun lessonDao(): LessonDao
}