package br.com.mizaeldouglas.api_mvp.api

import br.com.mizaeldouglas.api_mvp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonPlaceApi {

    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}