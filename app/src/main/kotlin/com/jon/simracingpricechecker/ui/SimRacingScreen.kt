package com.jon.simracingpricechecker.ui

import androidx.compose.runtime.Composable

abstract class SimRacingScreen {

    abstract val SCREEN_NAME: String

    @Composable
    abstract fun Show()

    @Composable
    protected abstract fun Content()
}