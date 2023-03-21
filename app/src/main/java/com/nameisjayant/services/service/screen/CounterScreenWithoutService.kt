package com.nameisjayant.services.service.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay


@Composable
fun CounterAppWithoutService() {
    var counter by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = counter){
        delay(1000)
        counter++
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "$counter")
    }

}