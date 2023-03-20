package com.nameisjayant.services.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext


@Composable
fun AirplaneModeScreen() {

    var data by remember { mutableStateOf("") }
    val context = LocalContext.current
    val broadcastReceiver = remember {
        object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                val bundle = intent?.getBooleanExtra("state",false) ?: return
                 data = if(bundle){
                     "Airplane mode enabled"
                 } else {
                     "Airplane mode is disabled"
                 }
            }

        }
    }

    DisposableEffect(key1 = true){
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).apply {
            context.registerReceiver(broadcastReceiver,this)
        }
        onDispose {
            context.unregisterReceiver(broadcastReceiver)
        }
    }


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = data)
    }

}