package com.arturomarmolejo.exomusicapp.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class Migrations {
    val migration_1_2: Migration =
        object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE People ADD COLUMN image STRING")
            }
        }
}