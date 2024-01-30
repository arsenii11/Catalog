package net.marcoromano.catalog.app.ui.catalog.itemslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalog.app.domain.GetItemsListUseCase
import com.example.catalog.app.ui.catalog.categories.CategoriesUiState
import com.example.catalog.app.ui.catalog.itemslist.ItemsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import net.marcoromano.catalog.app.domain.GetCategoriesUseCase
import javax.inject.Inject

@HiltViewModel
internal class ItemsListViewModel @Inject constructor(
    private val useCase: GetItemsListUseCase
) : ViewModel() {

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> get() = _loadingState

    private val _errorState: MutableLiveData<String> = MutableLiveData()
    val errorState: LiveData<String> get() = _errorState

    val myResponse: MutableLiveData<ItemsListUiState> = MutableLiveData() //TODO: fix

    fun fetchData() {
        _loadingState.value = true
        viewModelScope.launch {
            try {
                val response: ItemsListUiState = useCase.invoke()
                myResponse.value = response
            } catch (e: Exception) {
                _errorState.value = "Failed to fetch data"
            }
        }
    }
}