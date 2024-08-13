package com.alkye.articles.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alkye.articles.R
import com.alkye.articles.data.Article
import com.alkye.articles.ui.theme.Dimensions.extraPadding
import com.alkye.articles.ui.theme.Dimensions.padding
import com.alkye.articles.ui.theme.Dimensions.spaceSmall

@Composable
fun HomeScreen(data: Array<Article>, onClick: (article: Article) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo"
                )
            }
            /* Card(
                 elevation = CardDefaults.cardElevation(cardElevation),
                 colors = CardDefaults.cardColors(Color.White),
                 shape = RoundedCornerShape(
                     corner = CornerSize(cornerSize)
                 )
             ) {
                 Text(text = "Search....")
                 Image(
                     painter = painterResource(id = R.drawable.search),
                     contentDescription = "Search"
                 )
             }*/
        }
        item {
            HorizontalArticleList(data = data, onClick, false)
        }
        item {
            HorizontalDivider(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .width(100.dp)
                    .padding(start = padding),
                thickness = spaceSmall,
            )
        }

        item {
            Text(
                text = stringResource(id = R.string.recent_articles),
                fontFamily = FontFamily(Font(R.font.strawford_black)),
                modifier = Modifier.padding(start = extraPadding),
                fontSize = 16.sp
            )
        }
        item {
            RecentArticleList(data = data, onClick)
        }
    }
}
