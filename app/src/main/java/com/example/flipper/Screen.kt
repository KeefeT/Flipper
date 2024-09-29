package com.example.flipper

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import kotlin.random.Random

val TAG: String = "Keefe"
val list: MutableList<String> = mutableListOf()

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("MTG Coin Flipper!", textAlign = TextAlign.Center, modifier = modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(30.dp))
        Row {
            //Image row
            Spacer(modifier = Modifier.size(10.dp))
            ClickableCard(
                painter = painterResource(id = R.drawable.okaun),
                description = "Okaun",
                onClickExtra = {
                    if (list.contains("okaun")) {
                        list.remove("okaun")
                    } else {
                        list.add("okaun")
                    }
                    Log.i(TAG, "onClickExtra okaun, list: $list")
                }
            )
            Spacer(modifier = Modifier.size(10.dp))
            ClickableCard(
                painter = painterResource(id = R.drawable.zndrsplt),
                description = "Zndrsplt",
                onClickExtra = {
                    if (list.contains("zndrsplt")) {
                        list.remove("zndrsplt")
                    } else {
                        list.add("zndrsplt")
                    }
                    Log.i(TAG, "onClickExtra zndrsplt, list: $list")
                }
            )
            Spacer(modifier = Modifier.size(10.dp))
        }
        Spacer(modifier = Modifier.size(40.dp))
        Button(onClick = {
            val successes = flip(list)
            //ResultDialog(successes = successes)
        }) {
            Text("Flip!")
        }
    }
}

@Composable
fun ResultDialog(successes: Int) {
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        confirmButton = { /*TODO*/ },
        title = { Text(text = "Results!", textAlign = TextAlign.Center) },
        text = { Text(text = "There were $successes successful flips!") }
    )
}

fun flip(list: MutableList<String>) {
    var result: Boolean = true
    var successes: Int = 0

    while (list.size > 0) {
        Log.i(TAG, "Flipping coin for: ${list.first()}")
        while (result) {
            result = Random.nextBoolean()
            if (result) {
                successes += 1
            }
        }
        list.removeFirst()
    }
    Log.i(TAG, "Total successes: $successes")
}