package com.demo.floatingsnackbar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ScreenAViewModel : ViewModel() {

    fun showSnackbar() {
        viewModelScope.launch {
            val action: suspend () -> Unit = {
                SnackbarController.sendEvent(
                    event = SnackbarEvent(
                        message = "Action pressed!"
                    )
                )
            }
            val event = SnackbarEvent(
                message = "Hello from ViewModel",
                action = SnackbarAction(
                    name = "Click me!",
                    action = action
                )
            )
            SnackbarController.sendEvent(event = event)
        }
    }
}
