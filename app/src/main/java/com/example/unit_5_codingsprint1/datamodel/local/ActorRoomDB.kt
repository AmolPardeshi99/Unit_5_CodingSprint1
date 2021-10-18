package com.example.unit_5_codingsprint1.datamodel.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ActorData::class], version = 1)
abstract class ActorRoomDB : RoomDatabase() {

    abstract fun getActorDAO(): ActorDataDAO

    companion object {
        private var instance: ActorRoomDB? = null
        fun getDataBaseObject(context: Context): ActorRoomDB {
            if (instance == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    ActorRoomDB::class.java,
                    "actor_db"
                )
                builder.fallbackToDestructiveMigration()
                instance = builder.build()
                return instance as ActorRoomDB
            } else return instance as ActorRoomDB

        }
    }
}