package com.alkye.articles.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.alkye.articles.R
import com.alkye.articles.data.Article
import com.alkye.articles.ui.theme.Dimensions.cardElevation
import com.alkye.articles.ui.theme.Dimensions.cornerSize
import com.alkye.articles.ui.theme.Dimensions.padding
import com.alkye.articles.ui.theme.Dimensions.sizeNormal
import com.alkye.articles.ui.theme.Dimensions.sizeXSmall
import com.alkye.articles.ui.theme.Dimensions.spaceExtraSmall

@Composable
fun RecentArticleListItem(article: Article, onClick: (article: Article) -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(cardElevation),
        modifier = Modifier
            .padding(padding).fillMaxWidth()
            .clickable { onClick(article) },
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(
            corner = CornerSize(cornerSize)
        )
    ) {

        Row(modifier = Modifier.fillMaxWidth()) {
            val context = LocalContext.current
            val imageResource: Int = context.resources.getIdentifier(article.articleImage, null, context.packageName)
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = stringResource(id = R.string.article_image),
                modifier = Modifier.weight(0.4f).fillMaxHeight()
            )
            Column(modifier = Modifier
                .padding(padding)
                .weight(0.6f)) {
                Row(modifier = Modifier.padding(padding)) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "Ellipse",
                        modifier = Modifier.padding(top = spaceExtraSmall)
                    )
                    Text(
                        text = article.category,
                        fontFamily = FontFamily(Font(R.font.strawford_regular)),
                        fontSize = sizeXSmall,
                        modifier = Modifier.padding(start = spaceExtraSmall)
                    )
                }
                Text(
                    text = article.title,
                    fontFamily = FontFamily(Font(R.font.strawford_black)),
                    fontSize = sizeNormal,
                    modifier = Modifier.padding(start=padding)
                )
                Text(
                    text = article.description,
                    fontFamily = FontFamily(Font(R.font.strawford_regular)),
                    fontSize = sizeNormal,
                    modifier = Modifier.padding(start=padding)
                )
                
                Text(
                    text = article.publishedDate,
                    fontFamily = FontFamily(Font(R.font.strawford_extralight)),
                    fontSize = sizeNormal,
                    modifier = Modifier.padding(padding)
                )
            }
        }
    }
}