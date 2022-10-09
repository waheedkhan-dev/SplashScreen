package com.codecollapse.splashscreenapi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
open class SplashApp : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimberConfiguration()
    }

    protected open fun setTimberConfiguration() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
