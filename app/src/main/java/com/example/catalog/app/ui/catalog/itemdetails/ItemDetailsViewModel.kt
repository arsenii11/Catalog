package com.example.catalog.app.ui.catalog.itemdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalog.app.domain.GetItemDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ItemDetailsViewModel @Inject constructor(
    private val useCase: GetItemDetailsUseCase
) : ViewModel() {

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _errorState: MutableLiveData<String> = MutableLiveData()
    val errorState: LiveData<String> get() = _errorState

    val myResponse: MutableLiveData<ItemDetailsUiState> = MutableLiveData() //TODO: fix

    fun fetchData(itemId:String) {
        _loadingState.value = true
        viewModelScope.launch {
            try {
                val response: ItemDetailsUiState = useCase.invoke(itemId)
                myResponse.value = response
            } catch (e: Exception) {
                _errorState.value = "Failed to fetch data"
            }
        }
    }
}