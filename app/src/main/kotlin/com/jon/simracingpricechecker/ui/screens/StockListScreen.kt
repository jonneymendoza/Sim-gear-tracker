package com.jon.simracingpricechecker.ui.screens

import androidx.compose.runtime.Composable
import com.jon.simracingpricechecker.ui.SimRacingScreen

class StockListScreen : SimRacingScreen() {
    override val SCREEN_NAME: String
        get() = "StockListScreen"

    @Composable
    override fun Show() {
        val navController = rememberNavController()
        Content()
    }

    @Composable
    override fun Content() {

    }

}