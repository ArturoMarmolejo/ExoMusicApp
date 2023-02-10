package com.arturomarmolejo.exomusicapp.model.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arturomarmolejo.exomusicapp.model.items.TrackResponse

//    {"wrapperType":"track", "kind":"song", "artistId":503970811, "collectionId":1440825109, "trackId":1440825761,
//        "artistName":"Iggy Azalea", "collectionName":"The New Classic (Deluxe Version)", "trackName":"Fancy (feat. Charli XCX)",
//        "collectionCensoredName":"The New Classic (Deluxe Version)", "trackCensoredName":"Fancy (feat. Charli XCX)",
//        "artistViewUrl":"https://music.apple.com/us/artist/iggy-azalea/503970811?uo=4",
//        "collectionViewUrl":"https://music.apple.com/us/album/fancy-feat-charli-xcx/1440825109?i=1440825761&uo=4",
//        "trackViewUrl":"https://music.apple.com/us/album/fancy-feat-charli-xcx/1440825109?i=1440825761&uo=4",
//        "previewUrl":"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview122/v4/fa/8b/5d/fa8b5d0b-d230-e8ac-150e-b0959ed0eebd/mzaf_7740412818285566586.plus.aac.p.m4a",
//        "artworkUrl30":"https://is5-ssl.mzstatic.com/image/thumb/Music112/v4/40/29/3f/40293f21-8ab5-62dd-9766-476d47c314d2/14UMGIM08053.rgb.jpg/30x30bb.jpg",
//        "artworkUrl60":"https://is5-ssl.mzstatic.com/image/thumb/Music112/v4/40/29/3f/40293f21-8ab5-62dd-9766-476d47c314d2/14UMGIM08053.rgb.jpg/60x60bb.jpg",
//        "artworkUrl100":"https://is5-ssl.mzstatic.com/image/thumb/Music112/v4/40/29/3f/40293f21-8ab5-62dd-9766-476d47c314d2/14UMGIM08053.rgb.jpg/100x100bb.jpg",
//        "collectionPrice":9.99, "trackPrice":1.29, "releaseDate":"2014-02-17T12:00:00Z", "collectionExplicitness":"explicit",
//        "trackExplicitness":"explicit", "discCount":1, "discNumber":1, "trackCount":15, "trackNumber":5, "trackTimeMillis":199938, "country":"USA",
//        "currency":"USD", "primaryGenreName":"Hip-Hop/Rap", "contentAdvisoryRating":"Explicit", "isStreamable":true},

@Entity("TrackList")
data class TrackListEntity (
    @PrimaryKey
    val trackId: Int,
    val artistName: String,
    val artworkURL60: String,
    val trackPrice: Double,
    val primaryGenreName: String
)

fun TrackResponse?.mapToTrackList(): TrackListEntity =
    TrackListEntity(
        trackId = this?.trackId ?: 0,
        artistName = this?.artistName ?: "-",
        artworkURL60 = this?.artworkUrl30 ?: "-",
        trackPrice = this?.trackPrice ?: 0.00,
        primaryGenreName = this?.primaryGenreName ?: "-"
    )




