package com.example.catalog.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_background
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_error
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_errorContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_inverseOnSurface
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_inversePrimary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_inverseSurface
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onBackground
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onError
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onErrorContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onPrimary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onPrimaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onSecondary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onSecondaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onSurface
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onSurfaceVariant
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onTertiary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_onTertiaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_outline
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_outlineVariant
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_primary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_primaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_scrim
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_secondary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_secondaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_surface
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_surfaceTint
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_surfaceVariant
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_tertiary
import net.marcoromano.catalog.app.ui.theme.md_theme_dark_tertiaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_background
import net.marcoromano.catalog.app.ui.theme.md_theme_light_error
import net.marcoromano.catalog.app.ui.theme.md_theme_light_errorContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_inverseOnSurface
import net.marcoromano.catalog.app.ui.theme.md_theme_light_inversePrimary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_inverseSurface
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onBackground
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onError
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onErrorContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onPrimary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onPrimaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onSecondary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onSecondaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onSurface
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onSurfaceVariant
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onTertiary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_onTertiaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_outline
import net.marcoromano.catalog.app.ui.theme.md_theme_light_outlineVariant
import net.marcoromano.catalog.app.ui.theme.md_theme_light_primary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_primaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_scrim
import net.marcoromano.catalog.app.ui.theme.md_theme_light_secondary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_secondaryContainer
import net.marcoromano.catalog.app.ui.theme.md_theme_light_surface
import net.marcoromano.catalog.app.ui.theme.md_theme_light_surfaceTint
import net.marcoromano.catalog.app.ui.theme.md_theme_light_surfaceVariant
import net.marcoromano.catalog.app.ui.theme.md_theme_light_tertiary
import net.marcoromano.catalog.app.ui.theme.md_theme_light_tertiaryContainer

private val DarkColorScheme = darkColorScheme(
  primary = md_theme_dark_primary,
  onPrimary = md_theme_dark_onPrimary,
  primaryContainer = md_theme_dark_primaryContainer,
  onPrimaryContainer = md_theme_dark_onPrimaryContainer,
  secondary = md_theme_dark_secondary,
  onSecondary = md_theme_dark_onSecondary,
  secondaryContainer = md_theme_dark_secondaryContainer,
  onSecondaryContainer = md_theme_dark_onSecondaryContainer,
  tertiary = md_theme_dark_tertiary,
  onTertiary = md_theme_dark_onTertiary,
  tertiaryContainer = md_theme_dark_tertiaryContainer,
  onTertiaryContainer = md_theme_dark_onTertiaryContainer,
  error = md_theme_dark_error,
  onError = md_theme_dark_onError,
  errorContainer = md_theme_dark_errorContainer,
  onErrorContainer = md_theme_dark_onErrorContainer,
  outline = md_theme_dark_outline,
  background = md_theme_dark_background,
  onBackground = md_theme_dark_onBackground,
  surface = md_theme_dark_surface,
  onSurface = md_theme_dark_onSurface,
  surfaceVariant = md_theme_dark_surfaceVariant,
  onSurfaceVariant = md_theme_dark_onSurfaceVariant,
  inverseSurface = md_theme_dark_inverseSurface,
  inverseOnSurface = md_theme_dark_inverseOnSurface,
  inversePrimary = md_theme_dark_inversePrimary,
  surfaceTint = md_theme_dark_surfaceTint,
  outlineVariant = md_theme_dark_outlineVariant,
  scrim = md_theme_dark_scrim,
)

private val LightColorScheme = lightColorScheme(
  primary = md_theme_light_primary,
  onPrimary = md_theme_light_onPrimary,
  primaryContainer = md_theme_light_primaryContainer,
  onPrimaryContainer = md_theme_light_onPrimaryContainer,
  secondary = md_theme_light_secondary,
  onSecondary = md_theme_light_onSecondary,
  secondaryContainer = md_theme_light_secondaryContainer,
  onSecondaryContainer = md_theme_light_onSecondaryContainer,
  tertiary = md_theme_light_tertiary,
  onTertiary = md_theme_light_onTertiary,
  tertiaryContainer = md_theme_light_tertiaryContainer,
  onTertiaryContainer = md_theme_light_onTertiaryContainer,
  error = md_theme_light_error,
  onError = md_theme_light_onError,
  errorContainer = md_theme_light_errorContainer,
  onErrorContainer = md_theme_light_onErrorContainer,
  outline = md_theme_light_outline,
  background = md_theme_light_background,
  onBackground = md_theme_light_onBackground,
  surface = md_theme_light_surface,
  onSurface = md_theme_light_onSurface,
  surfaceVariant = md_theme_light_surfaceVariant,
  onSurfaceVariant = md_theme_light_onSurfaceVariant,
  inverseSurface = md_theme_light_inverseSurface,
  inverseOnSurface = md_theme_light_inverseOnSurface,
  inversePrimary = md_theme_light_inversePrimary,
  surfaceTint = md_theme_light_surfaceTint,
  outlineVariant = md_theme_light_outlineVariant,
  scrim = md_theme_light_scrim,
)

@Composable
fun AppTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit,
) {
  val colorScheme = when {
    dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
      val context = LocalContext.current
      if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    }

    darkTheme -> DarkColorScheme
    else -> LightColorScheme
  }
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content,
  )
}
