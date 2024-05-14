package com.xramos.mycomics.ui.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xramos.mycomics.data.network.client.Repository
import com.xramos.mycomics.domain.model.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    private val _hasSearch = mutableStateOf(false)

    val searchQuery = _searchQuery
    val hasSearch = _hasSearch

    private val _searchedCharacters = MutableStateFlow<List<CharacterModel>>(emptyList())
    val searchedCharacters = _searchedCharacters

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setSearch(value: Boolean) {
        _hasSearch.value = value
    }

    fun searchCharacters(search: String) {
        _hasSearch.value = true

        viewModelScope.launch {

            repository.searchCharacter(search)
                .onSuccess {

                _searchedCharacters.value = it

            }
                .onFailure {

                // TODO: Handle Error case
            }
        }
    }
}