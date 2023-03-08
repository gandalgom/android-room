package com.gandalgom.sample.room

import android.app.Application

import com.gandalgom.sample.room.repository.database.WordRoomDatabase
import com.gandalgom.sample.room.repository.WordRepository

class WordsApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    private val database by lazy { WordRoomDatabase.getDatabase(this) }

    val repository by lazy { WordRepository(database.wordDao()) }
}