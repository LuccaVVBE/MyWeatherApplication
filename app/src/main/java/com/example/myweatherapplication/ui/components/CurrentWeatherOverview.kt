package com.example.myweatherapplication.ui.components

import android.widget.Toast
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.myweatherapplication.ui.model.LocatieInfo
import com.example.myweatherapplication.ui.viewModel.LocationWeatherViewModel
import com.example.myweatherapplication.ui.viewModel.WeatherApiState

@Composable
fun CurrentWeatherOverview(
    modifier: Modifier,
    currentWeatherViewModel: LocationWeatherViewModel = viewModel(factory = LocationWeatherViewModel.Factory),
    location: String = "Gent",
) {
    val currentWeatherState by currentWeatherViewModel.uiState.collectAsState()

    // Only call getRepoWeatherLocation when the location changes
    DisposableEffect(location) {
        currentWeatherViewModel.getRepoWeatherLocation(location)
        onDispose {}
    }

    val context = LocalContext.current

    fun createToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    DisposableEffect(currentWeatherViewModel.weatherApiState) {
        when (currentWeatherViewModel.weatherApiState) {
            is WeatherApiState.Loading -> createToast("Loading...")
            is WeatherApiState.Error -> createToast("Error getting latest info.")
            is WeatherApiState.Success -> createToast("Successfully fetched latest info.")
            else -> null
        }
        onDispose {  }
    }



    WeatherLocationIdentifier(locatie = currentWeatherState.locatieInfo, modifier = modifier)
    Column(modifier = modifier.padding(top = 100.dp)) {
        WeatherInfoGrid(currentWeatherState.locatieInfo, modifier)
    }
}

@Composable
fun WeatherLocationIdentifier(locatie: LocatieInfo, modifier: Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = modifier
            .height(height = 100.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = locatie.placeName,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        AsyncImage(
            model = "https:".plus(locatie.icon),
            contentDescription = "Weather icon",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(128.dp)
        )
    }
}

@Composable
fun WeatherInfoGrid(locatieInfo: LocatieInfo, modifier: Modifier) {
    val cards = listOf(
        CardInfo(modifier, "Temperature", locatieInfo.temp.toString(), "°C"),
        CardInfo(modifier, "Feels like", locatieInfo.feelsLike.toString(), "°C"),
        CardInfo(modifier, "Wind speed", locatieInfo.windSpeed.toString(), "kmh"),
        CardInfo(modifier, "Wind direction", locatieInfo.windDirection.toString(), "°"),
        CardInfo(modifier, "Humidity", locatieInfo.humidity.toString(), "%"),
        CardInfo(modifier, "Visibility", locatieInfo.visibility.toString(), "km"),
        CardInfo(modifier, "Pressure", locatieInfo.pressure.toString(), "hPa"),
        CardInfo(modifier, "UV index", locatieInfo.uv.toString(), ""),
    )
    val enterTransition = fadeIn() + slideInVertically(
        initialOffsetY = { -it },
        animationSpec = tween(700, easing = FastOutSlowInEasing)
    )
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp)) {
        items(cards.size) { index ->
            MyWeatherInfoCard(cardInfo = cards[index])
        }
    }
}

@Composable
fun MyWeatherInfoCard(cardInfo: CardInfo) {
    Card(
        modifier = cardInfo.modifier
            .size(120.dp)
            .padding(6.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = cardInfo.name, modifier = Modifier.padding(horizontal = 30.dp, vertical = 15.dp))
                Text(text = cardInfo.value.plus(cardInfo.unit), Modifier.padding(horizontal = 30.dp))
            }
        }
    }
}

data class CardInfo(
    val modifier: Modifier,
    val name: String,
    val value: String,
    val unit: String
)