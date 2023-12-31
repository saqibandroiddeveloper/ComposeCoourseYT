package com.aryan.composecoourseyt.tweetsyapp.utills

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton
import androidx.profileinstaller.ProfileVerifier
import kotlinx.coroutines.guava.await

class ProfileVerifierLogger @Inject constructor(
    @Singleton private val scope : CoroutineScope
) {
    companion object {
        val TAG = "Profile Installer"
    }
    operator fun invoke() = scope.launch {
        val status = ProfileVerifier.getCompilationStatusAsync().await()
        Log.d(TAG, "Status code: ${status.profileInstallResultCode}")
        Log.d(
            TAG,
            when {
                status.isCompiledWithProfile -> "App compiled with profile"
                status.hasProfileEnqueuedForCompilation() -> "Profile enqueued for compilation"
                else -> "Profile not compiled nor enqueued"
            },
        )
    }
}