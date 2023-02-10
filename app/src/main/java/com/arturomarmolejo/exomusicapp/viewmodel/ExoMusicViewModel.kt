package com.arturomarmolejo.exomusicapp.viewmodel

import android.provider.Contacts.Intents.UI
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arturomarmolejo.exomusicapp.model.domain.TrackListEntity
import com.arturomarmolejo.exomusicapp.model.items.TrackListResponse
import com.arturomarmolejo.exomusicapp.rest.ExoMusicRepository
import com.arturomarmolejo.exomusicapp.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExoMusicViewModel @Inject constructor(
    private val exoMusicRepository: ExoMusicRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    private val genres = arrayListOf("classic", "rock", "pop")
    var trackUri : String = ""
    private var isInitialized = false

    init {
        if(!isInitialized) {
            getTrackList()
            isInitialized = true
        }
    }

    private val _classicTrackList: MutableLiveData<UIState<TrackListResponse>> = MutableLiveData(UIState.LOADING)
    val classicTrackList: LiveData<UIState<TrackListResponse>> get() = _classicTrackList

    private val _rockTrackList: MutableLiveData<UIState<TrackListResponse>> = MutableLiveData(UIState.LOADING)
    val rockTrackList: LiveData<UIState<TrackListResponse>> get() = _rockTrackList

    private val _popTrackList: MutableLiveData<UIState<TrackListResponse>> = MutableLiveData(UIState.LOADING)
    val popTrackList: LiveData<UIState<TrackListResponse>> get() = _popTrackList

    private fun getTrackList() {
        genres.forEach { genre ->
            viewModelScope.launch(ioDispatcher) {
                exoMusicRepository.getTracksByGenre(genre).collect() {
                    when(genre) {
                        "classic" -> _classicTrackList.postValue(it)
                        "rock" -> _rockTrackList.postValue(it)
                        "pop" -> _popTrackList.postValue(it)
                    }
                }
            }

        }
    }

}