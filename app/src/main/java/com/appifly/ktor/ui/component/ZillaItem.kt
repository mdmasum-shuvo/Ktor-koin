package com.appifly.ktor.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ZilaItem(zilaName: String?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp), shape = RoundedCornerShape(5.dp)
    ) {

        TextView16_W600(value = zilaName ?: "---")

    }
}