package com.arturomarmolejo.exomusicapp.rest

import com.arturomarmolejo.exomusicapp.model.items.TrackListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ExoMusicApi {

    @GET(GENDER)
    suspend fun getTrackListByGender(): Response<TrackListResponse>


    companion object {

//        Tab 1:
//        https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50
//
//        Tab 2:
//        https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
//
//        Tab 3:
//        https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
     //   Classic Tab should load:
//        https://itunes.apple.com/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50
//
//        Pop Tab should load:
//        https://itunes.apple.com/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50
//
//        Rock Tab should load:
//        https://itunes.apple.com/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50

        const val GENDER = "gender"
        const val BASE_URL = " https://itunes.apple.com/search${GENDER}&amp;media=music&amp;entity=song&amp;limit=50"


    }
}