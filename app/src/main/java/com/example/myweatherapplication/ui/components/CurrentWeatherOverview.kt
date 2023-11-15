package com.example.myweatherapplication.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CurrentWeatherOverview(location:String = "Gent", modifier: Modifier){

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
         LazyVerticalGrid(columns =  GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)){
                items(8){
                    MyWeatherInfoCard(modifier = Modifier.padding(bottom=20.dp))
                }
         }
    }

}

@Composable
fun MyWeatherInfoCard(modifier:Modifier){
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
                Text(text = "Info naam"  )
                Text(text = "Info value" )
            }
        }
    }
}