package com.jon.simracingpricechecker.ui.screens.state

import com.jon.simracingpricechecker.domain.model.Product

sealed class StockListUiState {
    data class Success(val products: List<Product>) : StockListUiState()

    data class Error(val exception: Throwable) : StockListUiState()

    object Loading : StockListUiState()

    object Idle : StockListUiState()
}