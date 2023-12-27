package com.example.myweatherapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.myweatherapplication.R
import com.example.myweatherapplication.ui.theme.MyWeatherApplicationTheme


/**
 * Composable voor het maken van een dialoogvenster voor het toevoegen van een nieuwe weerlocatie.
 *
 * @param weatherLocationName De naam van de weerlocatie.
 * @param onWeatherLocationNameChanged De callback-functie die wordt aangeroepen wanneer de weerlocatienaam wordt gewijzigd.
 * @param onWeatherLocationSave De callback-functie die wordt aangeroepen wanneer de gebruiker de weerlocatie opslaat.
 * @param onDismissRequest De callback-functie die wordt aangeroepen wanneer het dialoogvenster wordt gesloten.
 * @param errorMessage Het foutbericht dat moet worden weergegeven (indien aanwezig).
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CreateLocation(
    weatherLocationName: String,
    onWeatherLocationNameChanged: (String) -> Unit,
    onWeatherLocationSave: () -> Unit,
    onDismissRequest: () -> Unit,
    errorMessage:String
) {
    Dialog(
        onDismissRequest = onDismissRequest,
    ) {
        Card(
            shape = RoundedCornerShape(dimensionResource(R.dimen.cardCornerRadius)),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.largePadding)),
            ) {
                Text("Enter location name:")
                OutlinedTextField(
                    value = weatherLocationName,
                    onValueChange = onWeatherLocationNameChanged,
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Location name") },
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { onWeatherLocationSave() }),
                    supportingText = {
                        if (errorMessage != "") {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = errorMessage,
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                )



                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.mediumSpacer)))
                Row {
                    Spacer(Modifier.weight(1F))
                    TextButton(onClick = onDismissRequest) {
                        Text("Cancel")
                    }
                    Spacer(Modifier.width(dimensionResource(id = R.dimen.smallSpacer)))
                    TextButton(onClick = {
                            onWeatherLocationSave()
                    }){
                        Text("Save")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CreateWeatherLocationPreview() {
    MyWeatherApplicationTheme {
        CreateLocation("Gent", {}, {}, {},"")
    }
}