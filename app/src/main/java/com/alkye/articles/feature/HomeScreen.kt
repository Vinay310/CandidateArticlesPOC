package com.alkye.articles.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.alkye.articles.R
import com.alkye.articles.data.Article
import com.alkye.articles.ui.theme.Dimensions.cardElevation
import com.alkye.articles.ui.theme.Dimensions.cornerSize
import com.alkye.articles.ui.theme.Dimensions.extraPadding
import com.alkye.articles.ui.theme.Dimensions.icon
import com.alkye.articles.ui.theme.Dimensions.padding
import com.alkye.articles.ui.theme.Dimensions.sizeNormal
import com.alkye.articles.ui.theme.Dimensions.spaceXXLarge
import com.alkye.articles.ui.theme.Dimensions.spaceXXXLarge

@Composable
fun HomeScreen(data: Array<Article>, onClick: (article: Article) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spaceXXLarge)
    ) {
        item {
            Row(
                modifier = Modifier
                    .padding(top = spaceXXLarge, start = padding, end = padding)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(id = R.string.logo),
                    modifier = Modifier.size(icon)
                )
                Card(
                    elevation = CardDefaults.cardElevation(cardElevation),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(
                        corner = CornerSize(cornerSize)
                    )
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(padding)
                    ) {
                        Text(text = "Search ....")
                        Image(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = stringResource(id = R.string.search)
                        )
                    }
                }
            }
        }
        item {
            HorizontalArticleList(data = data, onClick, false)
        }

        item {
            Text(
                text = stringResource(id = R.string.recent_articles),
                fontFamily = FontFamily(Font(R.font.strawford_black)),
                modifier = Modifier.padding(top = extraPadding, start = padding),
                fontSize = sizeNormal
            )
        }
        items(data.size) { model ->
            RecentArticleListItem(data[model], onClick)
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding), // Ensure the Column fills the width
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Card(
                    elevation = CardDefaults.cardElevation(cardElevation),
                    colors = CardDefaults.cardColors(Color.White),
                    shape = RoundedCornerShape(
                        corner = CornerSize(cornerSize)
                    ),
                    modifier = Modifier.width(spaceXXXLarge)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = stringResource(id = R.string.view_all))
                    }
                }
            }
        }
    }
}
