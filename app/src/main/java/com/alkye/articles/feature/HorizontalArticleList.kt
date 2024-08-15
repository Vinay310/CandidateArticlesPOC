package com.alkye.articles.feature

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alkye.articles.data.Article
import com.alkye.articles.ui.theme.Dimensions.extraPadding

@Composable
fun HorizontalArticleList(data : Array<Article>, onClick:(article : Article)->Unit,isIconVisible: Boolean) {
    LazyRow(modifier = Modifier.padding(top = extraPadding)
    ) {
        items(data.size) { model ->
            ArticleListItem(data[model],onClick,isIconVisible)
        }
    }
}