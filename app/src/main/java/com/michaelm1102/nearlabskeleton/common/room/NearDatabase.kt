package com.michaelm1102.nearlabskeleton.common.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.michaelm1102.nearlabskeleton.modules.login.data.data_source.LoginDao

//Todo add entities
@Database(entities = [], views = [], version = 0)
//Todo rename database name
abstract class NearDatabase : RoomDatabase() {
    //TODO add dao

    abstract val loginDao:LoginDao

    companion object {
        val DatabaseName: String = ""
    }
}