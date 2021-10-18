package com.example.unit_5_codingsprint1.datamodel.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "actorsData")
data class ActorData(
    @ColumnInfo(name = "name") var name:String?,
    @ColumnInfo(name = "imageurl") var imageurl:String?,
    @ColumnInfo(name = "countryname") var countryname:String?,
    @ColumnInfo(name = "birthdate") var birthdate:String?,
    @ColumnInfo(name = "deathdate") var deathdate:String?
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int? = null
}