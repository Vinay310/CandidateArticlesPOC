package com.alkye.articles.feature

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextRowItem(
    text1: String,
    text2: String,
    text3: String,
    fontSize: TextUnit,
    fontFamily: FontFamily
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = text1,
            modifier = Modifier.weight(1f),
            fontSize = fontSize,
            fontFamily = fontFamily,
        )
        Text(
            text = text2,
            modifier = Modifier.weight(1f),
            fontSize = fontSize,
            fontFamily = fontFamily
        )
        Text(
            text = text3,
            modifier = Modifier.weight(1f),
            fontSize = fontSize,
            fontFamily = fontFamily
        )
    }
}