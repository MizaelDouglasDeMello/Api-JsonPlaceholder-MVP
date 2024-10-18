package br.com.mizaeldouglas.api_mvp.model

import android.util.Log
import br.com.mizaeldouglas.api_mvp.api.RetrofitService

class PostApi {
    suspend fun getPosts(): List<Post> {
        val jsonPlace = RetrofitService.getJsonPlace()
//        var response: Response<List<Post>>? = null

        try {
            val response = jsonPlace.getPosts()
            if (response.isSuccessful) {
                response.body()?.let { post ->
                    return post
                }
            }
        } catch (e: Exception) {
            Log.i("getPosts", "getPosts: ${e.message}")
        }

        return  emptyList()
    }
}