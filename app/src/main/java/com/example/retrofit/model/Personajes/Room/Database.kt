package com.example.retrofit.model.Personajes.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.DcEntityResultP

@Database(
    entities = [DcEntityPerRAM::class, DcEntityResultP::class], version = 1
)
abstract class PersonajesDb: RoomDatabase() {
     abstract fun ReturnPersonajes(): DaoInterfacePersonajes

}