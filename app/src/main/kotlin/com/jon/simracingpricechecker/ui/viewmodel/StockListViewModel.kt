package com.jon.simracingpricechecker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jon.simracingpricechecker.domain.usecase.GetAbruzziStockItems
import com.jon.simracingpricechecker.ui.screens.state.StockListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockListViewMode @Inject constructor(
    private val getAbruzziStockItems: GetAbruzziStockItems
) : ViewModel() {

    private val _uiState = MutableStateFlow<StockListUiState>(StockListUiState.Idle)

    val uiState: StateFlow<StockListUiState> = _uiState.asStateFlow()

    fun getAbruzziStock() {
        _uiState.value = StockListUiState.Loading
        viewModelScope.launch {
            getAbruzziStockItems.invoke()
                .catch { exception -> _uiState.value = StockListUiState.Error(exception) }
                .collect { productList ->
                    _uiState.value = StockListUiState.Success(productList)
                }
        }
    }
}