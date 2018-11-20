package ru.sorokin.dev.fitkittest.di

import android.arch.persistence.room.Room
import android.content.Context
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.sorokin.dev.fitkittest.model.local.dao.LessonDao
import ru.sorokin.dev.fitkittest.model.local.db.AppDatabase
import ru.sorokin.dev.fitkittest.model.remote.service.FitkitService
import ru.sorokin.dev.fitkittest.model.repository.ScheduleRepository
import ru.sorokin.dev.fitkittest.ui.home.HomeViewModel
import java.util.concurrent.TimeUnit

val mainModule = module {
    single { createOkHttpClient() }
    single { createWebService<FitkitService>(okHttpClient = get(), url = FitkitService.BASE_URL) }

    single { createDb(androidContext()) }
    single { getLessonDao(get()) }
    single { ScheduleRepository(fitkitService = get(), lessonDao = get()) }
    viewModel { HomeViewModel(get()) }
}




fun createDb(applicationContext: Context): AppDatabase {
    return Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "fitkit"
    ).build()
}

fun getLessonDao(db: AppDatabase): LessonDao {
    return db.lessonDao()
}

fun createOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)
            .build()
}


inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    return retrofit.create(T::class.java)
}