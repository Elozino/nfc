package com.example.nativesentrystride.presentation.scan

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nativesentrystride.R
import com.example.nativesentrystride.utils.INTENT_ACTION_NFC_READ
import com.example.nativesentrystride.utils.NfcBroadcastReceiver
import com.example.nativesentrystride.utils.getParcelableCompatibility

@OptIn(ExperimentalStdlibApi::class)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Scan(navController: NavController) {
    var nfcCardId by remember {
        mutableStateOf("")
    }

    NfcBroadcastReceiver { tag ->
        nfcCardId = tag.id.toHexString()
        Log.d("TAG INFO", tag.id.toHexString())
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_white),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.matchParentSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Read Card: $nfcCardId", fontSize = 16.sp)
            Button(
                onClick = {},
                shape = CircleShape,
                modifier = Modifier.size(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray,
                )
            ) {
                Text(text = "Scan", fontSize = 26.sp)
            }
        }
    }
}
