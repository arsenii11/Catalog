package com.example.catalog.app.ui.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.catalog.app.ui.catalog.categories.CategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import net.marcoromano.catalog.app.ui.AppUi
import com.example.catalog.app.ui.theme.AppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)
    WindowCompat.setDecorFitsSystemWindows(window, false)
    setContent {
      AppTheme {
        AppUi()
      }
    }
  }
}
