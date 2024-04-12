package com.xramos.mycomics.ui.screen

import androidx.lifecycle.ViewModel
import com.xramos.mycomics.data.network.client.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

}