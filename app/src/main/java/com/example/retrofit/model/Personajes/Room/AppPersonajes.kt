package com.example.retrofit.model.Personajes.Room

import android.app.Application
import androidx.room.Room

class AppPersonajes:Application() {
    val room = Room.databaseBuilder(this, PersonajesDb::class.java,"Personajes").build()
}