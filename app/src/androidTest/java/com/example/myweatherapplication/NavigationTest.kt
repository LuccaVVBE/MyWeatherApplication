package com.example.myweatherapplication

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipeLeft
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.myweatherapplication.ui.WeatherApp
import com.example.myweatherapplication.ui.util.WeatherNavigationType
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {
    private val locationName: String = "Brussel"
    private val errorMessage : String = "Error: could not find location"
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            WeatherApp(WeatherNavigationType.BOTTOM_NAVIGATION, navController = navController)
        }
    }

    @Test
    fun verifyStartDestination() {
        composeTestRule
            .onNodeWithText("Current location")
            .assertIsDisplayed()
    }

    @Test
    fun navigateToList() {
        composeTestRule
            .onNodeWithContentDescription("navigate to list page")
            .performClick()
        composeTestRule
            .onNodeWithText("List")
            .assertIsDisplayed()
    }

    @Test
    fun clickAddLocation() {
        composeTestRule
            .onNodeWithContentDescription("Nieuwe locatie")
            .performClick()
        composeTestRule
            .onNodeWithText("Location name")
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Save")
            .assertIsDisplayed()
    }

    @Test
    fun canAddLocation() {
        composeTestRule
            .onNodeWithContentDescription("Nieuwe locatie")
            .performClick()
        composeTestRule
            .onNodeWithText("Location name")
            .performTextInput(locationName)
        composeTestRule
            .onNodeWithText("Save")
            .performClick()
        composeTestRule
            .onNodeWithText("Save")
            .assertDoesNotExist()
    }
    @Test
    fun addLocationError() {
        composeTestRule
            .onNodeWithContentDescription("Nieuwe locatie")
            .performClick()
        composeTestRule
            .onNodeWithText("Location name")
            .performTextInput("jqsdkfmlqkdsjf")
        composeTestRule
            .onNodeWithText("Save")
            .performClick()
        composeTestRule
            .onNodeWithText(errorMessage)
            .assertIsDisplayed()
    }

    @Test
    fun canRemoveLocation(){
        composeTestRule
            .onNodeWithContentDescription("navigate to list page")
            .performClick()
        composeTestRule.onNodeWithText("Gent")
            .performTouchInput { swipeLeft() }
        composeTestRule.onNodeWithText("Gent")
            .assertIsNotDisplayed()
    }
}