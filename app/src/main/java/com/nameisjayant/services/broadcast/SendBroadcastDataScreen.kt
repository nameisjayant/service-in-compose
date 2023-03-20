package com.nameisjayant.services.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SendBroadCastDataScreen() {

    var data by remember { mutableStateOf("") }
    val context = LocalContext.current
    val broadCastReceiver = remember {
        object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                data = intent?.getStringExtra("data") ?: "No Data"
            }

        }
    }

    DisposableEffect(key1 = true){
        IntentFilter("event").apply {
            context.registerReceiver(broadCastReceiver,this)
        }
        onDispose {
            context.unregisterReceiver(broadCastReceiver)
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = data)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent("event").apply {
                putExtra("data","Data from broadcast !")
            }
            context.sendBroadcast(intent)
        }) {
            Text(text = "Send Broadcast data")
        }

    }

}