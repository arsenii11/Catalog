package com.example.catalog.app.ui.catalog.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.marcoromano.catalog.app.domain.GetCategoriesUseCase
import com.example.catalog.app.ui.catalog.CategoryUiState
import javax.inject.Inject

@HiltViewModel
internal class CategoriesViewModel @Inject constructor(
  private val useCase: GetCategoriesUseCase
) : ViewModel() {

  private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
  val loadingState: LiveData<Boolean> get() = _loadingState

  private val _errorState: MutableLiveData<String> = MutableLiveData()
  val errorState: LiveData<String> get() = _errorState

  val myResponse: MutableLiveData<CategoryUiState> = MutableLiveData() //TODO: fix

  fun fetchAccountData() {
    _loadingState.value = true
    viewModelScope.launch {
      try {
       val response: CategoryUiState = useCase.invoke()
        myResponse.value = response
      } catch (e: Exception) {
        _errorState.value = "Failed to fetch data"
      } finally {
        _loadingState.value = false
      }
    }
  }
}
