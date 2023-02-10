package com.arturomarmolejo.exomusicapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.arturomarmolejo.exomusicapp.model.domain.TrackListEntity


@Database(
    entities = [
        TrackListEntity::class
    ],
    version = 2
)

abstract class ExoMusicDatabase : RoomDatabase() {
    abstract fun getExoMusicDAO(): ExoMusicDAO
}