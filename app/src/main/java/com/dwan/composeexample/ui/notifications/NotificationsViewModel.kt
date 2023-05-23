package com.dwan.composeexample.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dwan.composeexample.model.NotificationModel

class NotificationsViewModel : ViewModel() {

    private val _notifications = MutableLiveData<List<NotificationModel>>().apply {
        value = listOf(
            NotificationModel("Notif. 1", "description 1", id = 1234),
            NotificationModel("Notif. 2", "description 2", id = 1839),
            NotificationModel("Notif. 3", "description 3", id = 2345),
            NotificationModel("Notif. 4", "description 4", id = 3456),
            NotificationModel("Notif. 5", "description 5", id = 4567),
            NotificationModel("Notif. 6", "description 6", id = 4321),
            NotificationModel("Notif. 7", "description 7", id = 5678),
            NotificationModel("Notif. 8", "description 8", id = 6789),
            NotificationModel("Notif. 9", "description 9", id = 7654),
            NotificationModel("Notif. 10", "description 10", id = 8904),
            NotificationModel("Notif. 11", "description 11", id = 8908),
            NotificationModel("Notif. 12", "description 12", id = 1210),
            NotificationModel("Notif. 13", "description 13", id = 7322)
        )
    }
    val notifications: LiveData<List<NotificationModel>> = _notifications

}