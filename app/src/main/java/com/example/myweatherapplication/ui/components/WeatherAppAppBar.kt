package com.example.myweatherapplication.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * Aangepaste [TopAppBar] voor de weerapplicatie.
 *
 * @param canNavigateBack Geeft aan of de terugknop moet worden weergegeven.
 * @param navigateUp Caellback voor het afhandelen van de navigatie naar boven.
 * @param currentScreenTitle Huidige schermtitel die wordt weergegeven in de [TopAppBar].
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAppAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    currentScreenTitle: Int,
) {
    TopAppBar(
        colors = TopAppBarDefaults.run {
            topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        scrolledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
        titleContentColor = MaterialTheme.colorScheme.primary
        )
        },

        title = {
            Text(stringResource(id = currentScreenTitle))
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "navigate back",
                    )
                }
            }
        },
    )
}