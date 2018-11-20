package ru.sorokin.dev.fitkittest

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.sorokin.dev.fitkittest.di.mainModule
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(mainModule))

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }


    }
}