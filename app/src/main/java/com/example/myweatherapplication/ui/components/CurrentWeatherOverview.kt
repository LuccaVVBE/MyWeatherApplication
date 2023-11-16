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
fun CurrentWeatherOverview(location:String = "Gent", modifier: Modifier, currentWeatherViewModel: LocationWeatherViewModel = viewModel()  ){
    val currentWeatherState by currentWeatherViewModel.uiState.collectAsState();

    fun getLocatieInfo():LocatieInfo{
        return LocatieInfo(
            currentWeatherState.temp,
            currentWeatherState.icon,
            currentWeatherState.windSpeed,
            currentWeatherState.windDirection,
            currentWeatherState.pressure,
            currentWeatherState.humidity,
            currentWeatherState.visibility,
            currentWeatherState.uv
            )
    }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = modifier
            .height(height = 100.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = location,
            modifier = modifier

                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        Icon(Icons.Outlined.Warning, "Weather icon", modifier = Modifier.align(Alignment.CenterHorizontally))

    }
    Column(modifier=modifier.padding( top = 100.dp)) {
         WeatherInfoGrid(getLocatieInfo(), Modifier)
    }

}

@Composable
fun WeatherInfoGrid(locatieInfo: LocatieInfo, modifier:Modifier) {

    val cards = listOf(
        MyWeatherInfoCard(modifier, "temp", locatieInfo.temp.toString()),
        MyWeatherInfoCard(modifier, "pressure", locatieInfo.pressure.toString()),
        MyWeatherInfoCard(modifier, "windspeed", locatieInfo.windSpeed.toString()),
        MyWeatherInfoCard(modifier, "winddirection", locatieInfo.windDirection.toString()),
        MyWeatherInfoCard(modifier, "humidity", locatieInfo.humidity.toString()),
        MyWeatherInfoCard(modifier, "visibility", locatieInfo.visibility.toString()),
        MyWeatherInfoCard(modifier, "uv", locatieInfo.uv.toString().plus("%")),

    )


    LazyVerticalGrid(columns =  GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)){
            items(cards.size){index ->
                cards[index];
        }
    }
}


@Composable
fun MyWeatherInfoCard(modifier: Modifier, name: String, value: String){
    Card(
        modifier
            .size(120.dp)
            .padding(6.dp)
        ,
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor= Color.LightGray)
    ){
        Box(contentAlignment = Alignment.Center){
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = name  )
                Text(text = value )
            }
        }
    }
}