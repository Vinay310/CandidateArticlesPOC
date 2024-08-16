package com.alkye.articles.feature

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.alkye.articles.R
import com.alkye.articles.data.Article
import com.alkye.articles.data.DataManager
import com.alkye.articles.ui.theme.Dimensions.cardElevation
import com.alkye.articles.ui.theme.Dimensions.cornerSize
import com.alkye.articles.ui.theme.Dimensions.extraPadding
import com.alkye.articles.ui.theme.Dimensions.extraXPadding
import com.alkye.articles.ui.theme.Dimensions.icon
import com.alkye.articles.ui.theme.Dimensions.padding
import com.alkye.articles.ui.theme.Dimensions.sizeXLarge
import com.alkye.articles.ui.theme.Dimensions.sizeXMedium
import com.alkye.articles.ui.theme.Dimensions.sizeXXSmall
import com.alkye.articles.ui.theme.Dimensions.spaceExtraLarge
import com.alkye.articles.ui.theme.Dimensions.spaceMedium
import com.alkye.articles.ui.theme.Dimensions.spaceXXLarge
import com.alkye.articles.ui.theme.Dimensions.spaceXXXLarge

@Composable
fun ArticleDetailScreen(selectedArticle: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = spaceExtraLarge,
                end = extraPadding,
                bottom = spaceXXLarge
            )
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = extraPadding),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painterResource(id = R.drawable.back),
                "Back Button",
                modifier = Modifier
                    .size(icon)
                    .clickable {
                        DataManager.switchPages(null)
                    }
            )
            Image(
                painterResource(id = R.drawable.logo),
                "Logo",
                modifier = Modifier.size(icon)
            )
        }
        Text(
            text = selectedArticle.title,
            fontSize = sizeXMedium,
            letterSpacing = 2.sp,
            fontFamily = FontFamily(Font(R.font.strawford_black)),
            modifier = Modifier.padding(top = padding, start = extraPadding)
        )
        Text(
            text = selectedArticle.description,
            fontSize = sizeXMedium,
            fontFamily = FontFamily(Font(R.font.strawford_regular)),
            modifier = Modifier.padding(start = extraPadding),
            letterSpacing = 2.sp
        )
        TextRowItem(
            stringResource(id = R.string.type),
            stringResource(id = R.string.category),
            stringResource(id = R.string.date),
            sizeXXSmall,
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
                modifier = Modifier.padding(top = spaceMedium, start = extraPadding),
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
                    .padding(extraXPadding)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                Image(
                    painterResource(id = R.drawable.save),
                    stringResource(id = R.string.save),
                    modifier = Modifier.size(icon)
                )
                Image(
                    painterResource(id = R.drawable.share),
                    stringResource(id = R.string.share),
                    modifier = Modifier.size(icon)
                )
            }
        }
        Text(
            text = selectedArticle.longDescription,
            fontFamily = FontFamily(Font(R.font.scillanarrow_regular)),
            fontSize = sizeXLarge,
            modifier = Modifier.padding(top = padding, start = extraPadding)
        )

        val category = listOf(
            "Spatial Computing",
            "Industrial Meta verse",
            "AR in Retail",
            "Digital Interaction",
            "Enterprise Tools",
            "AR/VR Technology"
        )

        Column(
            modifier = Modifier
                .height(spaceXXXLarge)
                .padding(start = padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(category.size) {
                    Card(
                        elevation = CardDefaults.cardElevation(cardElevation),
                        modifier = Modifier
                            .padding(padding)
                            .width(spaceXXXLarge),
                        colors = CardDefaults.cardColors(Color.White),
                        shape = RoundedCornerShape(
                            corner = CornerSize(cornerSize)
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = category[it]
                            )
                        }

                    }
                }
            }
        }
        Text(
            text = stringResource(id = R.string.related_articles),
            fontFamily = FontFamily(Font(R.font.strawford_black)),
            modifier = Modifier.padding(top = extraPadding, start = extraPadding)
        )
        BackHandler {
            DataManager.switchPages(null)
        }
        Column(modifier = Modifier.padding(start = padding)) {
            HorizontalArticleList(DataManager.data, onClick = {}, true)
        }


    }
}