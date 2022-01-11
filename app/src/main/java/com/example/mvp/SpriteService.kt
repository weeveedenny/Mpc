package com.example.mvp

import retrofit2.http.GET
import retrofit2.http.Path

interface SpriteService {

    @GET("other/home/{id}.png")
    suspend fun getSprite(@Path("id") id: Int): String
}