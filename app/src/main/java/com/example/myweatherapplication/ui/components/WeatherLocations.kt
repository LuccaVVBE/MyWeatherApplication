package com.example.myweatherapplication.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myweatherapplication.ui.viewModel.LocationWeatherViewModel

@Composable
fun WeatherLocations(modifier: Modifier, goToClickedLocation: (locatie: String) -> Unit, locationWeatherViewModel : LocationWeatherViewModel = viewModel(factory = LocationWeatherViewModel.Factory)){
    val weatherLocationListState by locationWeatherViewModel.uiListState.collectAsState();
    val listState = rememberLazyListState();
    LazyColumn(state = listState) {
        itemsIndexed(weatherLocationListState.weatherLocationList){
            index, item-> WeatherLocation(modifier, goToClickedLocation, weatherLocationListState.weatherLocationList.get(index).placeName)
        }

    }
}

@Composable
fun WeatherLocation(modifier: Modifier, goToClickedLocation: (locatie: String) -> Unit, placeName:String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .clickable{goToClickedLocation(placeName)},

    ) {
        Column(
            modifier = Modifier.padding(8.dp),

        ) {
            Row {
                Icon(
                    Icons.Filled.LocationOn,
                    contentDescription = "LocatieIcon",
                )
                Text(
                    text = "Locatie",
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Text(
                text = "Temperatuur",
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
            )
            Divider()
        }
    }
}