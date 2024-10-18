package br.com.mizaeldouglas.api_mvp.model

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)