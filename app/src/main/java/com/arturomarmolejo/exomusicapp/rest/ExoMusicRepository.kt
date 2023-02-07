package com.arturomarmolejo.exomusicapp.rest

import com.arturomarmolejo.exomusicapp.di.ExoMusicApp
import com.arturomarmolejo.exomusicapp.model.items.TrackListResponse
import com.arturomarmolejo.exomusicapp.utils.UIState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ExoMusicRepository {
    fun getTracksByGender(): Flow<UIState<TrackListResponse>>

}

class ExoMusicRepositoryImpl @Inject constructor(
    private val exoMusicApi: ExoMusicApi
)

