package com.example.myweatherapplication.ui.components

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.myweatherapplication.ui.model.LocatieInfo
import com.example.myweatherapplication.ui.viewModel.LocationWeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherLocations(modifier: Modifier, goToClickedLocation: (locatie: String) -> Unit, locationWeatherViewModel : LocationWeatherViewModel = viewModel(factory = LocationWeatherViewModel.Factory)) {
    val weatherLocationListState by locationWeatherViewModel.uiListState.collectAsState();
    val listState = rememberLazyListState();
    LazyColumn(state = listState) {
        itemsIndexed(weatherLocationListState.weatherLocationList, key={_, item->item.placeName}) { index, item ->


            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(direction = DismissDirection.EndToStart)) {
                // Swiping from left to right
                Toast.makeText(LocalContext.current, "Deleted ".plus(item.placeName), Toast.LENGTH_SHORT).show()
                locationWeatherViewModel.removeLocation(item.placeName)

            }

            SwipeToDismiss(
                state = dismissState,
                directions = setOf(DismissDirection.EndToStart),
                background = {
                    // this background is visible when we swipe.
                    // it contains the icon

                    // background color
                    val backgroundColor by animateColorAsState(
                        when (dismissState.targetValue) {
                            DismissValue.DismissedToStart -> Color.Red.copy(alpha = 0.8f)
                            else -> Color.White
                        }
                    )

                    // icon size
                    val iconScale by animateFloatAsState(
                        targetValue = if (dismissState.targetValue == DismissValue.DismissedToStart) 1.3f else 0.5f
                    )

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(color = backgroundColor)
                            .padding(end = 16.dp), // inner padding
                        contentAlignment = Alignment.CenterEnd // place the icon at the end (left)
                    ) {
                        Icon(
                            modifier = Modifier.scale(iconScale),
                            imageVector = Icons.Outlined.Delete,
                            contentDescription = "Delete",
                            tint = Color.White
                        )
                    }
                },
                dismissContent = {
                    // List item
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                    ) {
                        WeatherLocation(modifier, goToClickedLocation, item)
                    }
                }
            )
        }
    }
}

@Composable
fun WeatherLocation(modifier: Modifier, goToClickedLocation: (locatie: String) -> Unit, locatie:LocatieInfo) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
            .clickable{goToClickedLocation(locatie.placeName)},

    ) {
        Column(
            modifier = Modifier.padding(8.dp),

        ) {
            Row {
                AsyncImage(model = "https:".plus(locatie.icon), "Weather icon" )

                Text(
                    text = locatie.placeName,
                    style = MaterialTheme.typography.bodyMedium
                )
            }


            Text(
                text = locatie.temp.toString(),
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
            )
            Divider()
        }
    }
}
