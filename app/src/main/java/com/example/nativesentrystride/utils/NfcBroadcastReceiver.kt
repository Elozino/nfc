package com.example.nativesentrystride.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.nfc.NfcAdapter
import android.nfc.Tag
import android.os.Build
import android.os.Build.VERSION_CODES.TIRAMISU
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext

const val INTENT_ACTION_NFC_READ = "com.example.nativesentrystride.utils.INTENT_ACTION_NFC_READ"

@RequiresApi(TIRAMISU)
@Composable
fun NfcBroadcastReceiver(onSuccess: (Tag) -> Unit) {
    val context = LocalContext.current

    val currentOnSystemEvent by rememberUpdatedState(newValue = onSuccess)

    DisposableEffect(context) {
        val intentFilter = IntentFilter(INTENT_ACTION_NFC_READ)
        val broadcast = object: BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
                intent?.getParcelableCompatibility(NfcAdapter.EXTRA_TAG, Tag::class.java)?.let{
                    tag ->  currentOnSystemEvent(tag)
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.registerReceiver(
                broadcast, intentFilter,
                Context.RECEIVER_NOT_EXPORTED
            )
        } else {
            context.registerReceiver(broadcast, intentFilter, Context.RECEIVER_NOT_EXPORTED)
        }


        onDispose {
            context.unregisterReceiver(broadcast)
        }

    }
}
