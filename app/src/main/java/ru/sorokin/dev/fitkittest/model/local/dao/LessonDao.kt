package ru.sorokin.dev.fitkittest.model.local.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import ru.sorokin.dev.fitkittest.model.local.entiry.Lesson

@Dao
interface LessonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(obj: Lesson)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateAll(obj: List<Lesson>)

    @Update
    fun update(obj: Lesson)
    @Update
    fun updateAll(obj: List<Lesson>)

    @Delete
    fun delete(obj: Lesson)
    @Delete
    fun deleteAll(obj: List<Lesson>)

    @Query("DELETE FROM lessons")
    fun clear()

    @Query("SELECT * FROM lessons ORDER BY weekDay")
    fun selectAll(): LiveData<List<Lesson>>



}