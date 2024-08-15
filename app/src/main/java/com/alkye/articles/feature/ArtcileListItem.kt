package com.alkye.articles.feature

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alkye.articles.R
import com.alkye.articles.data.Article
import com.alkye.articles.ui.theme.Dimensions.cardElevation
import com.alkye.articles.ui.theme.Dimensions.cornerSize
import com.alkye.articles.ui.theme.Dimensions.extraXPadding
import com.alkye.articles.ui.theme.Dimensions.padding
import com.alkye.articles.ui.theme.Dimensions.spaceExtraSmall
import com.alkye.articles.ui.theme.Dimensions.spaceLarge


@Composable
fun ArticleListItem(article: Article, onClick: (article: Article) -> Unit,isIconVisible:Boolean) {
    Box {
        Card(
            elevation = CardDefaults.cardElevation(cardElevation),
            modifier = Modifier
                .padding(padding)
                .clickable { onClick(article) }
                .width(300.dp),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(
                corner = CornerSize(cornerSize)
            )
        ) {
            Column {
                val context = LocalContext.current
                val imageResource: Int =
                    context.resources.getIdentifier(article.articleImage, null, context.packageName)
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(id = R.string.article_image)
                )
                Row(modifier = Modifier.padding(padding)) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipse),
                        contentDescription = "Ellipse",
                        modifier = Modifier.padding(top = spaceExtraSmall)
                    )
                    Text(
                        text = article.category,
                        fontFamily = FontFamily(Font(R.font.strawford_regular)),
                        fontSize = 11.sp,
                        modifier = Modifier.padding(start = spaceExtraSmall)
                    )
                }
                val annotatedString = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append(article.title)
                    }
                    withStyle(style = SpanStyle(color = Color.Black)) {
                        append(article.description)
                    }
                }
                Text(text = annotatedString, modifier = Modifier.padding(padding))
                Text(
                    text = article.publishedDate,
                    fontFamily = FontFamily(Font(R.font.strawford_extralight)),
                    fontSize = 16.sp,
                    modifier = Modifier.padding(padding)
                )
            }
        }
        if(isIconVisible) {
            Image(painter = painterResource(id = R.drawable.youtube), modifier = Modifier
                .padding(extraXPadding)
                .size(spaceLarge), contentDescription ="Youtube")
        }
    }
}