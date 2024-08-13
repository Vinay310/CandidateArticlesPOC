package com.alkye.articles.feature

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.alkye.articles.R
import com.alkye.articles.data.Article
import com.alkye.articles.data.DataManager
import com.alkye.articles.ui.theme.Dimensions.cardElevation
import com.alkye.articles.ui.theme.Dimensions.cornerSize
import com.alkye.articles.ui.theme.Dimensions.extraLarge
import com.alkye.articles.ui.theme.Dimensions.extraPadding
import com.alkye.articles.ui.theme.Dimensions.icon
import com.alkye.articles.ui.theme.Dimensions.padding
import com.alkye.articles.ui.theme.Dimensions.sizeMedium
import com.alkye.articles.ui.theme.Dimensions.sizeXLarge
import com.alkye.articles.ui.theme.Dimensions.spaceExtraLarge
import com.alkye.articles.ui.theme.Dimensions.spaceMedium
import com.alkye.articles.ui.theme.Dimensions.spaceXLarge

@Preview
@Composable
fun ArticleDetailScreen(selectedArticle: Article = Article("", "", "", "", "", "")) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = extraPadding,
                top = spaceExtraLarge,
                end = extraPadding,
                bottom = extraPadding
            )
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = padding, end = padding),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painterResource(id = R.drawable.back),
                "Back Button",
                modifier = Modifier
                    .size(spaceXLarge)
                    .clickable {
                        DataManager.switchPages(null)
                    }
            )
            Image(
                painterResource(id = R.drawable.logo),
                "Logo",
                modifier = Modifier.size(spaceXLarge)
            )
        }
        Text(
            text = selectedArticle.title,
            fontSize = extraLarge,
            letterSpacing = 2.sp,
            fontFamily = FontFamily(Font(R.font.strawford_black))
        )
        Text(
            text = selectedArticle.description,
            fontSize = extraLarge,
            fontFamily = FontFamily(Font(R.font.strawford_regular)),
            letterSpacing = 2.sp
        )
        TextRowItem(
            stringResource(id = R.string.type),
            stringResource(id = R.string.category),
            stringResource(id = R.string.date),
            sizeMedium,
            FontFamily(Font(R.font.strawford_light))
        )
        TextRowItem(
            stringResource(id = R.string.article),
            selectedArticle.category,
            selectedArticle.publishedDate,
            sizeXLarge,
            FontFamily(Font(R.font.strawford_medium))
        )
        Box {
            Card(
                elevation = CardDefaults.cardElevation(cardElevation),
                colors = CardDefaults.cardColors(Color.White),
                modifier = Modifier.padding(top = spaceMedium),
                shape = RoundedCornerShape(
                    corner = CornerSize(cornerSize)
                )
            ) {
                val context = LocalContext.current
                val imageResource: Int = context.resources.getIdentifier(
                    selectedArticle.articleImage,
                    null,
                    context.packageName
                )
                Image(
                    painterResource(imageResource),
                    stringResource(id = R.string.article_image)
                )
            }
            Row(
                modifier = Modifier
                    .padding(extraPadding)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painterResource(id = R.drawable.save),
                    stringResource(id = R.string.article_image),
                    modifier = Modifier.size(icon)
                )
                Image(
                    painterResource(id = R.drawable.share),
                    stringResource(id = R.string.article_image),
                    modifier = Modifier.size(icon)
                )
            }
        }
        Text(
            text = selectedArticle.longDescription,
            fontFamily = FontFamily(Font(R.font.strawford_regular)),
            fontSize = sizeXLarge,
            modifier = Modifier.padding(start = padding, top = padding)
        )

        Text(
            text = stringResource(id = R.string.related_articles),
            fontFamily = FontFamily(Font(R.font.strawford_black)),
            modifier = Modifier.padding(top = extraPadding, start = padding)
        )
        BackHandler {
            DataManager.switchPages(null)
        }
        HorizontalArticleList(DataManager.data, onClick = {}, true)


    }
}