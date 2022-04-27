package com.decagon.androidweek10task_sq_010.presentation.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "posts"
)
data class Posts(
    @PrimaryKey(autoGenerate = true)
    var tablepostID: Int? = null,
    val id: Int,
    val body: String,
    val title: String,
    val userId: Int
) : Serializable
