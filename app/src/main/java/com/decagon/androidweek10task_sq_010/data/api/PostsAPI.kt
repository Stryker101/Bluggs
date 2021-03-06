package com.decagon.androidweek10task_sq_010.data.api

import com.decagon.androidweek10task_sq_010.presentation.models.Comments
import com.decagon.androidweek10task_sq_010.presentation.models.Posts
import retrofit2.Response
import retrofit2.http.*

interface PostsAPI {
    @GET("/posts")
    suspend fun getPosts(
        @Query("userId") userId: Int? = null
    ): Response<List<Posts>>

    @GET("/posts/{postId}/comments")
    suspend fun getComments(
        @Path("postId") postId: Int
    ): Response<List<Comments>>

    @POST("/posts")
    suspend fun addPosts(
        @Body posts: Posts
    ): Response<Posts>

    @POST("/comments")
    suspend fun addComments(
        @Query("postId") postId: Int,
        @Body comments: Comments
    ): Response<Comments>
}
