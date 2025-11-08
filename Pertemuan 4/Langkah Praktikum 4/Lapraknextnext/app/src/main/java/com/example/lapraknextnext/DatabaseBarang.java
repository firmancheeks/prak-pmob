package com.example.lapraknextnext;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;

import kotlin.jvm.Volatile;

@Database(entities = [Barang::class], version = 1, exportSchema = false)
abstract class DatabaseBarang: RoomDatabase() {
    abstract fun barangDao(): barangDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseBarang? = null

        fun getDatabase(context:Context): DatabaseBarang {
        return INSTANCE ?: synchronized (this){
            val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseBarang::class.java,
                "db_barang"
            ).build()
            INSTANCE = instance
        instance
            }
        }
    }
}
