package com.nameisjayant.services

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nameisjayant.services.broadcast.AirplaneModeScreen
import com.nameisjayant.services.broadcast.SendBroadCastDataScreen
import com.nameisjayant.services.notification.ShowNotificationScreen
import com.nameisjayant.services.screen.CounterAppWithService
import com.nameisjayant.services.screen.CounterAppWithoutService
import com.nameisjayant.services.ui.theme.ServicesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServicesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   // CounterAppWithService()
                 ///   AirplaneModeScreen()
                   // SendBroadCastDataScreen()
                    ShowNotificationScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ServicesTheme {
        Greeting("Android")
    }
}