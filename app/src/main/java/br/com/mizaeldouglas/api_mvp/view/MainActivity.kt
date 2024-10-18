package br.com.mizaeldouglas.api_mvp.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.mizaeldouglas.api_mvp.R
import br.com.mizaeldouglas.api_mvp.databinding.ActivityMainBinding
import br.com.mizaeldouglas.api_mvp.model.Post
import br.com.mizaeldouglas.api_mvp.model.PostApi
import br.com.mizaeldouglas.api_mvp.presenter.IPostPresenter
import br.com.mizaeldouglas.api_mvp.presenter.PostPresenter

class MainActivity : AppCompatActivity(), IPostPresenter {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var postPresenter: PostPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val postApi = PostApi()

        postPresenter = PostPresenter(this, postApi)
    }

    override fun onStart() {
        super.onStart()
        postPresenter.getPosts()
    }

    override fun onDestroy() {
        super.onDestroy()
        postPresenter.onDestroy()
    }

    override fun get(posts: List<Post>) {
        var result = ""
        posts.forEach { post->
            result += "\nTitle: (${post.id})${post.title} \n"
        }

        binding.txtList.text = result
    }

    override fun loading(loading: Boolean) {
        if (loading){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}