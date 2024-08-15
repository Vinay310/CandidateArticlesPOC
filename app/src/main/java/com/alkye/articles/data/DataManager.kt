package com.alkye.articles.data

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.alkye.articles.feature.PAGES
import com.alkye.articles.utils.Constants
import com.google.gson.Gson

/*
* Class to handle data and navigation based on currentPage
*/
object DataManager {
    var data = emptyArray<Article>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(PAGES.HOME)
    var currentArticle: Article? = null

    fun loadDataFromAssetFile(context: Context) {
        val json =
            context.assets.open(Constants.ARTICLES_JSON).bufferedReader().use { it.readText() }
        data = Gson().fromJson(json, Array<Article>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(article: Article?) {
        if (currentPage.value == PAGES.HOME) {
            currentArticle = article
            currentPage.value = PAGES.DETAIL
        } else {
            currentPage.value = PAGES.HOME
        }
    }

}