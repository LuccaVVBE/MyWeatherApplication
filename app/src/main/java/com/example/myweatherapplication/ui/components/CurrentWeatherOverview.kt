package com.example.myweatherapplication.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    currentWeatherViewModel: LocationWeatherViewModel = viewModel(factory=LocationWeatherViewModel.Factory),
    location: String = "",

    ){
    val currentWeatherState by currentWeatherViewModel.uiState.collectAsState()
    currentWeatherViewModel.getRepoWeatherLocation("Toronto")
    val context = LocalContext.current
    fun createToast(text:String ){
        val toast = Toast.makeText(context, text, Toast.LENGTH_LONG) // in Activity

        toast.show()
    }
    when(currentWeatherViewModel.weatherApiState){
        is WeatherApiState.Loading -> {
            createToast("Loading...")
        }
        is WeatherApiState.Error->{
            createToast("Error getting latest info.")
        }
        is WeatherApiState.Success ->{
            createToast("Succesfully fetched latest info.")
        }
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
            text = currentWeatherState.locatieInfo.placeName,
            modifier = modifier

                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
        AsyncImage(model = "https:".plus(currentWeatherState.locatieInfo.icon), "Weather icon", modifier = Modifier.align(Alignment.CenterHorizontally).width(128.dp).height(128.dp))

    }
    Column(modifier=modifier.padding( top = 100.dp)) {
         WeatherInfoGrid(currentWeatherState.locatieInfo, Modifier)
    }

}

@Composable
fun WeatherInfoGrid(locatieInfo: LocatieInfo, modifier:Modifier) {

    val cards = listOf(
        CardInfo (modifier, "temp", locatieInfo.temp.toString()),
        CardInfo (modifier, "Feels like", locatieInfo.feelsLike.toString()),

        CardInfo(modifier, "windspeed", locatieInfo.windSpeed.toString()),
        CardInfo(modifier, "winddirection", locatieInfo.windDirection.toString()),
        CardInfo(modifier, "humidity", locatieInfo.humidity.toString()),
        CardInfo(modifier, "visibility", locatieInfo.visibility.toString()),
        CardInfo(modifier, "pressure", locatieInfo.pressure.toString()),
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