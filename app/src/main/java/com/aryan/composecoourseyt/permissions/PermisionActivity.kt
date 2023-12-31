package com.aryan.composecoourseyt.permissions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.aryan.composecoourseyt.permissions.ui.theme.ComposeCoourseYTTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.shouldShowRationale

@ExperimentalPermissionsApi
class PermisionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCoourseYTTheme {
                val permissionState = rememberMultiplePermissionsState(
                    permissions = listOf(
                        android.Manifest.permission.CAMERA,
                        android.Manifest.permission.RECORD_AUDIO
                    )
                )
                val lifeCycleOwner = LocalLifecycleOwner.current
                DisposableEffect(key1 = lifeCycleOwner, effect = {
                    val observer = LifecycleEventObserver { _, event ->
                        if (event == Lifecycle.Event.ON_CREATE) {
                            permissionState.launchMultiplePermissionRequest()
                        }
                    }
                    lifeCycleOwner.lifecycle.addObserver(observer )
                    onDispose {
                        lifeCycleOwner.lifecycle.removeObserver(observer )
                    }
                })
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    permissionState.permissions.forEach { state ->
                        when (state.permission) {
                            android.Manifest.permission.CAMERA -> {
                                when {
                                    state.status.isGranted -> {
                                        Text(text = "Camera permission Granted")
                                    }

                                    state.status.shouldShowRationale -> {
                                        Text(text = "Camera permission is need to access Camera")
                                    }

                                    state.isPermanentlyDenied() -> {
                                        Text(text = "Camera permission permanently denied.Go to setting to enable")
                                    }
                                }
                            }

                            android.Manifest.permission.RECORD_AUDIO -> {
                                when {
                                    state.status.isGranted -> {
                                        Text(text = "Record Audio permission Granted")
                                    }

                                    state.status.shouldShowRationale -> {
                                        Text(text = "Record Audio permission is need to access Record Audio")
                                    }

                                    state.isPermanentlyDenied() -> {
                                        Text(text = "Record Audio permission permanently denied.Go to setting to enable")
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

