package com.decagon.androidweek10task_sq_010.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.decagon.androidweek10task_sq_010.presentation.models.Comments
import com.decagon.androidweek10task_sq_010.presentation.models.Posts

@Database(entities = [Posts::class, Comments::class], version = 1)
abstract class PostsDatabase : RoomDatabase() {

    abstract fun getPostDao(): PostsDAO
}
