package com.aryan.composecoourseyt

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.aryan.composecoourseyt.tweetsyapp.utills.ProfileVerifierLogger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import javax.inject.Provider

@HiltAndroidApp
class MyApp:Application(),ImageLoaderFactory {
    @Inject
    lateinit var imageLoader: Provider<ImageLoader>
    @Inject
    lateinit var profileVerifierLogger : ProfileVerifierLogger

    override fun onCreate() {
        super.onCreate()
//        Sync.initialize(context = this)
        profileVerifierLogger()
    }
    override fun newImageLoader(): ImageLoader = imageLoader.get()
}