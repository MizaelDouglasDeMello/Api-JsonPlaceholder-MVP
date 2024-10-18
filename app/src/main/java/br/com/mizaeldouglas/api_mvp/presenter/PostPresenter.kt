package br.com.mizaeldouglas.api_mvp.presenter

import br.com.mizaeldouglas.api_mvp.model.PostApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PostPresenter(
    private val view: IPostPresenter,
    private val postApi: PostApi
) {

    private val coroutine = CoroutineScope(Dispatchers.IO)

    fun getPosts() {
        view.loading(true)
        coroutine.launch {
            delay(2000)
            val post = postApi.getPosts()
            withContext(Dispatchers.Main){
                view.get(post)
                view.loading(false)
            }
        }
    }

    fun onDestroy(){
        coroutine.cancel()
    }
}