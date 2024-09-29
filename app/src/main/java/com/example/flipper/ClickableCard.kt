package com.example.flipper

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
public fun ClickableCard(painter: Painter, description: String, onClickExtra: () -> Unit) {
    var elevation by remember { mutableStateOf(5.dp) }
    var clicked by remember { mutableStateOf(false) }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        onClick = { if (clicked) {
            clicked = false
            elevation = 5.dp
            onClickExtra()
        } else {
            clicked = true
            elevation = 30.dp
            onClickExtra()
        }
        }
    ) {
        Image(
            painter = painter,
            contentDescription = description,
            modifier = Modifier.size(200.dp)
        )
    }
}