package com.alkye.articles.feature

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alkye.articles.data.Article
import com.alkye.articles.ui.theme.Dimensions.spaceLarge

@Composable
fun RecentArticleList(data : Array<Article>, onClick:(article: Article)->Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = spaceLarge)
    ) {
        items(data.size) { model ->
            RecentArticleListItem(data[model],onClick)
        }
    }
}