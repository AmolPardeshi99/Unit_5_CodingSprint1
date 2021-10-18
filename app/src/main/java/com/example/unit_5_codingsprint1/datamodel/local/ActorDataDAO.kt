package com.example.unit_5_codingsprint1.datamodel.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy


@Dao
interface ActorDataDAO {

    //adding data to room
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDataToRoom(actorData: ActorData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addDataListToRoom(actorDataList: ArrayList<ActorData>)
}