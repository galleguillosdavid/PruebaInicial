package com.example.retrofit.model.Personajes.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofit.model.Personajes.RetrofitP.GsonPersonajes.InicioP.DcEntityResultP


@Dao
interface DaoInterfacePersonajes {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllRazas(mPersonajes: DcEntityResultP)

    @Query ("SELECT * FROM DcEntityResultP_table" )
    fun getAll():List<DcEntityPerRAM>

    @Query ("SELECT  * FROM DcEntityResultP_table WHERE id=:mId")
    fun getById(mId: Int): DcEntityPerRAM

    @Insert
    fun insertAll(personajes: List<DcEntityResultP>)


}