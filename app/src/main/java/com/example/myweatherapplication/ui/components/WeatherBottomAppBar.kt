package com.example.myweatherapplication.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * Composable voor de bottombar van de weerapplicatie.
 *
 * @param goHome Callback-functie voor het navigeren naar het startscherm.
 * @param goToList Callback-functie voor het navigeren naar de lijstpagina.
 * @param showAddLocation Callback-functie voor het tonen van het dialoogvenster voor het toevoegen van een nieuwe locatie.
 */
@Composable
fun WeatherBottomAppBar(goHome: () -> Unit, goToList: () -> Unit, showAddLocation: ()-> Unit) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            IconButton(onClick = goHome) {
                Icon(Icons.Outlined.Home, contentDescription = "navigate to home screen")
            }

            IconButton(onClick = goToList) {
                Icon(
                    Icons.Filled.List,
                    contentDescription = "navigate to list page",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddLocation() },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Nieuwe locatie")
            }
        }
    )
}
