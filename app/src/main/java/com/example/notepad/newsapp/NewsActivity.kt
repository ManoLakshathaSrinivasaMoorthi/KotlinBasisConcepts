package com.example.notepad.newsapp

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.newsapp.model.Article
import com.example.newsapp.model.News
import com.example.notepad.R
import com.example.notepad.databinding.ActivityNewsBinding
import com.example.notepad.newsapp.adapter.Adapter
import com.example.notepad.newsapp.networking.ApiClient
import com.example.notepad.newsapp.networking.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsActivity : AppCompatActivity(),SwipeRefreshLayout.OnRefreshListener{
    private val apiKey: String = "fe1386d861f343f2bbb08659b49bb6cb"
    var articles: ArrayList<Article> = ArrayList()
    private lateinit var binding:ActivityNewsBinding
    private lateinit var adapter: Adapter
    private lateinit var viewManger: RecyclerView.LayoutManager
    private lateinit var errorLayout:ConstraintLayout
    private lateinit var errorTitle:TextView
    private lateinit var errorMessage:TextView
    private var btnRetry:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_news)
        binding.swipeRefresh.setOnRefreshListener(this)
        binding.swipeRefresh.setColorSchemeResources(R.color.colorAccent)

        viewManger = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = viewManger
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
       binding. recyclerView.isNestedScrollingEnabled = false

        loadJson("")
        errorLayout=findViewById(R.id.errorLayout)
        errorTitle=findViewById(R.id.errorTitle)
        errorMessage=findViewById(R.id.errorMessage)
        btnRetry=findViewById(R.id.btnRetry)
    }

    private fun loadJson(keyword: String) {

        binding.swipeRefresh.isRefreshing = true

        val apiInterface: ApiInterface? = ApiClient.getApiClient?.create(ApiInterface::class.java)

        val utils = Utils()

        val country: String = utils.getCountry()
        val language: String = utils.getLanguage()

        val call: Call<News>? = if (keyword.length < 0) {
            apiInterface?.getNewsSearch(keyword, language, "publishedAt", apiKey)
        } else {
            apiInterface?.getNews(country, apiKey)
        }


        call?.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>?, t: Throwable?) {
                binding.headlines.visibility = View.INVISIBLE
                binding.swipeRefresh.isRefreshing = false
                Toast.makeText(this@NewsActivity, "No Result", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                if (response!!.isSuccessful && response.body()?.article != null) {
                    if (articles.isNotEmpty()) {
                    }

                    articles = (response.body()!!.article as ArrayList<Article>?)!!
                    val context =NewsActivity()
                    adapter = Adapter(context, articles)
                    binding.recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                    binding.headlines.visibility = View.VISIBLE
                    binding.swipeRefresh.isRefreshing = false

                } else {
                    binding.headlines.visibility = View.INVISIBLE
                    binding.swipeRefresh.isRefreshing = false


                    val errorCode: String = when {
                        response.code() == 404 -> "404 not found"
                        response.code() == 500 -> "500 server broken"
                        else -> "unknown error"
                    }

                    showErrorMessage("No Result", "Try Again!\n$errorCode")
                }
            }
        })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val searchManger: SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView: SearchView = menu?.findItem(R.id.search_bar)?.actionView as SearchView
        val menuItem: MenuItem = menu.findItem(R.id.search_bar)

        searchView.setSearchableInfo(searchManger.getSearchableInfo(componentName))
        searchView.queryHint = "Search News..."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query?.length!! > 2) {
                    loadJson(query)
                } else {
                    Toast.makeText(
                        this@NewsActivity,
                        "Type more than two letters",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        menuItem.icon.setVisible(false, false)

        return true
    }

    override fun onRefresh() {
        loadJson("")
    }

    private fun onLoadRefresh(keyword: String) {
        binding.swipeRefresh.post {
            Runnable {
                loadJson(keyword)
            }
        }
    }

    fun showErrorMessage(title: String, message: String) {
        if (errorLayout.visibility == View.GONE) {
            errorLayout.visibility = View.VISIBLE
        }

     errorTitle.text = title
      errorMessage.text = message

        btnRetry?.setOnClickListener {
            onLoadRefresh("")
        }

    }
}