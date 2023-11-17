package com.example.myweatherapplication.ui.components

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myweatherapplication.ui.model.LocatieInfo
import com.example.myweatherapplication.ui.viewModel.LocationWeatherViewModel

@Composable
fun CurrentWeatherOverview(
    modifier: Modifier,
    currentWeatherViewModel: LocationWeatherViewModel = viewModel(),
    location: String = "",

){
    val currentWeatherState by currentWeatherViewModel.uiState.collectAsState()
    currentWeatherViewModel.getApiWeather("Toronto")



    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = modifier
            .height(height = 100.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = currentWeatherState.locatieInfo.placeName,
            modifier = modifier

                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Icon(Icons.Outlined.Warning, "Weather icon", modifier = Modifier.align(Alignment.CenterHorizontally))

    }
    Column(modifier=modifier.padding( top = 100.dp)) {
         WeatherInfoGrid(currentWeatherState.locatieInfo, Modifier)
    }

}

@Composable
fun WeatherInfoGrid(locatieInfo: LocatieInfo, modifier:Modifier) {

    val cards = listOf(
        CardInfo (modifier, "temp", locatieInfo.temp.toString()),
        CardInfo(modifier, "pressure", locatieInfo.pressure.toString()),
        CardInfo(modifier, "windspeed", locatieInfo.windSpeed.toString()),
        CardInfo(modifier, "winddirection", locatieInfo.windDirection.toString()),
        CardInfo(modifier, "humidity", locatieInfo.humidity.toString()),
        CardInfo(modifier, "visibility", locatieInfo.visibility.toString()),
        CardInfo(modifier, "uv", locatieInfo.uv.toString()),

    )


    LazyVerticalGrid(columns =  GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)){

        items(cards.size){ index ->
            var card = cards[index]
            MyWeatherInfoCard(cardInfo = card)
        }
    }
}


@Composable
fun MyWeatherInfoCard(cardInfo:CardInfo){
    Card(
        cardInfo.modifier
            .size(120.dp)
            .padding(6.dp)
        ,
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor= Color.LightGray)
    ){
        Box(contentAlignment = Alignment.Center){
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = cardInfo.name  )
                Text(text = cardInfo.value )
            }
        }
    }
}

data class CardInfo(
    val modifier:Modifier,
    val name:String,
    val value:String
)

