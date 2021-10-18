//package com.example.unit_5_codingsprint1.hilt
//
//import android.content.Context
//import androidx.room.Room
//import com.example.unit_5_codingsprint1.datamodel.local.ActorDataDAO
//import com.example.unit_5_codingsprint1.datamodel.local.ActorRoomDB
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//
//@Module
//@InstallIn(SingletonComponent::class)
//object Module {
//
//    @Singleton
//    @Provides
//    fun provideRoomDB(@ApplicationContext context: Context):ActorRoomDB{
//        val builder = Room.databaseBuilder(
//            context.applicationContext,
//            ActorRoomDB::class.java,
//            "actor_db"
//        )
//        builder.fallbackToDestructiveMigration()
//        return builder.build()
//    }
//
//    @Singleton
//    @Provides
//    fun provideActorDataDAO(db:ActorRoomDB):ActorDataDAO{
//        return db.getActorDAO()
//    }
//}