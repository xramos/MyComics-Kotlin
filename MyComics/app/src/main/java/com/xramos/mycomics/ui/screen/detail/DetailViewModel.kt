package com.xramos.mycomics.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xramos.mycomics.data.network.client.Repository
import com.xramos.mycomics.domain.model.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _characterModel: MutableStateFlow<CharacterModel?> = MutableStateFlow(null)
    val characterModel = _characterModel

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            val result = repository.getCharacter(id)
                .onSuccess {
                    _characterModel.value = it
                }
                .onFailure {
                    // TODO: Implement this!
                }
        }
    }
}