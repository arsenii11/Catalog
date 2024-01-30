package com.example.catalog.app.ui.catalog.categories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.marcoromano.catalog.app.domain.GetCategoriesUseCase
import javax.inject.Inject

@HiltViewModel
internal class CategoriesViewModel @Inject constructor(
  private val useCase: GetCategoriesUseCase
) : ViewModel() {

  private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
  val loadingState: LiveData<Boolean> get() = _loadingState

  private val _errorState: MutableLiveData<String> = MutableLiveData()
  val errorState: LiveData<String> get() = _errorState

  val myResponse: MutableLiveData<CategoriesUiState> = MutableLiveData() //TODO: fix

  fun fetchData() {
    _loadingState.value = true
    viewModelScope.launch {
      val response1: CategoriesUiState = useCase.invoke()
      Log.d("NetworkResponse", "Response: $response1")
      try {
       val response: CategoriesUiState = useCase.invoke()
        myResponse.value = response
      } catch (e: Exception) {
        _errorState.value = "Failed to fetch data"
      }
    }
  }
}
