package com.example.permissionhandlingcompose

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // [RECORD_AUDIO, CAMERA] example Queue fifo
    val visiblePermsissionDialogQueue = mutableStateListOf<String>()

    fun dismissDialog(
    ) {
        visiblePermsissionDialogQueue.removeFirst()
    }

    fun onPermissionResult(
        permission: String,
        isGranted: Boolean
    ) {
        if (!isGranted && !visiblePermsissionDialogQueue.contains(permission)) {
            visiblePermsissionDialogQueue.add(permission)
        }
    }
}