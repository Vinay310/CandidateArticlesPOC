package com.alkye.articles.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alkye.articles.data.DataManager
import com.alkye.articles.ui.theme.CandidateArticlesPOCTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        DataManager.loadDataFromAssetFile(this)
        setContent {
            CandidateArticlesPOCTheme(dynamicColor = false) {
                Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) { 
                    CandidateArticleApp()
                }
            }
        }
    }
}
@Composable
fun CandidateArticleApp() {
    if(DataManager.isDataLoaded.value) {
        if(DataManager.currentPage.value == PAGES.HOME) {
            HomeScreen(data = DataManager.data) {
                DataManager.switchPages(it )
            }
        }
        else {
            DataManager.currentArticle?.let { ArticleDetailScreen(it) }
        }
       
    }
}

// enum to handle the navigation between screens

enum class PAGES {
    HOME,
    DETAIL
}