package com.abit8.lovecalculator.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abit8.lovecalculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class RoomDataBase : RoomDatabase() {
    abstract fun loveDao(): Dao
}