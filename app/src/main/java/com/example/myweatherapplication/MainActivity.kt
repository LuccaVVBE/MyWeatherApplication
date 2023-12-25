package com.example.myweatherapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myweatherapplication.ui.WeatherApp
import com.example.myweatherapplication.ui.theme.MyWeatherApplicationTheme
import com.example.myweatherapplication.ui.util.WeatherNavigationType

/**
 * Main activity van de weer-applicatie.
 */
class MainActivity : ComponentActivity() {

    /**
     * Wordt opgeroepen wanneer de activity wordt aangemaakt. Hier wordt de UI ingesteld met behulp van Compose.
     */
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MyWeatherApplicationTheme {
                val windowSize = calculateWindowSizeClass(activity = this)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Compact -> {
                            WeatherApp(WeatherNavigationType.BOTTOM_NAVIGATION)
                        }

                        WindowWidthSizeClass.Medium -> {
                            WeatherApp(WeatherNavigationType.NAVIGATION_RAIL)
                        }

                        WindowWidthSizeClass.Expanded -> {
                            WeatherApp(navigationType = WeatherNavigationType.PERMANENT_NAVIGATION_DRAWER)
                        }

                        else -> {
                            WeatherApp(navigationType = WeatherNavigationType.BOTTOM_NAVIGATION)
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyWeatherApplicationTheme {
        WeatherApp(WeatherNavigationType.BOTTOM_NAVIGATION);
    }
}