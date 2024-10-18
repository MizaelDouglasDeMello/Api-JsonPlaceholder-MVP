package br.com.mizaeldouglas.api_mvp.presenter

import br.com.mizaeldouglas.api_mvp.model.Post

interface IPostPresenter {

    fun get(list: List<Post>)
    fun loading(loading: Boolean)
}