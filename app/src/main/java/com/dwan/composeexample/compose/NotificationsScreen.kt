package com.dwan.composeexample.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dwan.composeexample.R
import com.dwan.composeexample.model.NotificationModel
import com.dwan.composeexample.ui.notifications.NotificationsViewModel

@Composable
fun NotificationScreenView(viewModel: NotificationsViewModel) {
    //val viewState = viewModel.notifications.asFlow().collectAsState(initial = listOf())
    val notifications = viewModel.notifications.observeAsState()
    Column(Modifier.fillMaxSize()) {
        LazyColumn(Modifier.fillMaxHeight()) {
            items(items = notifications.value.orEmpty()) {
                NotificationCard(it)
            }
        }
    }
}


@Composable
fun NotificationCard(notification: NotificationModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), elevation = 10.dp
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_stat_name), contentDescription = "")
            Column(Modifier.padding(8.dp)) {
                Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                    Text(
                        text = notification.title, fontWeight = FontWeight.Bold,
                        fontSize = 14.sp, color = Color.Gray
                    )
                    Text(text = notification.id.toString(), fontSize = 11.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    Text(text = notification.description, fontSize = 10.sp, color = Color.Gray)
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF)
@Composable
fun Preview() {
    NotificationCard(NotificationModel("Title", "Description", 0))
}