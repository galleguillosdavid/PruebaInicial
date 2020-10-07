package com.example.retrofit.model.Personajes.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.DcPersonajesRAM


@Dao
interface InterfacePersonajes {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRazas(mPersonajes: DcPersonajesRAM )

}