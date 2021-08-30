package com.rudrik.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rudrik.shoppinglist.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1,
    exportSchema = false

)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDAO(): ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null


       operator fun invoke(context: Context): ShoppingDatabase {
            return instance ?: synchronized(this) {
                instance ?: createDatabase(context).also { instance = it }
            }
        }


//        private val LOCK = Any()
/*

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }
*/

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db"
            ).build()
    }
}