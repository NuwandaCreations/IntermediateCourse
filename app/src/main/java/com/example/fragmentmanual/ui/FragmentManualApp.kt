package com.example.fragmentmanual.ui

import android.app.Application
import com.example.fragmentmanual.core.di.appModule
import com.example.fragmentmanual.core.di.dataModule
import com.example.fragmentmanual.core.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FragmentManualApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@FragmentManualApp)
            modules(appModule, dataModule, viewModelModule)
        }
    }
}