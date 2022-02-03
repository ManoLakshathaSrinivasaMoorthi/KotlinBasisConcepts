package com.example.notepad.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.notepad.R
import com.example.notepad.databinding.ActivityNewsDetailBinding
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

class NewsDetailActivity : AppCompatActivity(),AppBarLayout.OnOffsetChangedListener {

    private var mUrl: String? = null
    private var mImg: String? = null
    private var mTitle: String? = null
    private var mDate: String? = null
    private var mSource: String? = null
    private var mAuthor: String? = null
    private var isHideToolbarView: Boolean = false
    private lateinit var binding:ActivityNewsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_news_detail)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.collapsingToolbar.title = ""

        binding.appbar.addOnOffsetChangedListener(this)


        val i: Intent = intent
        mUrl = i.getStringExtra("url")
        mImg = i.getStringExtra("img")
        mTitle = i.getStringExtra("title")
        mDate = i.getStringExtra("date")
        mSource = i.getStringExtra("source")
        mAuthor = i.getStringExtra("author")

        val utils = Utils()
        val requestOptions = RequestOptions()
        requestOptions.error(utils.getRandomColor())

        Glide.with(this)
            .load(mImg)
            .apply(requestOptions)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.backdrop)

        binding.titleOnAppbar.text = mSource
        binding.subtitleOnAppbar.text = mUrl
        binding.date.text = mDate

        val author: String?

        author = if (mAuthor != null) {
            "\u2022" + mAuthor
        } else {
            ""
        }

        binding.time.text = mSource + author + "\u2022" + utils.dateFormat(mDate.toString())

        inWebView(mUrl.toString())
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun inWebView(url: String) {
        binding.webView.settings.loadsImagesAutomatically = true
       binding. webView.settings.javaScriptEnabled = true
        binding.webView.settings.domStorageEnabled = true
        binding.webView.settings.setSupportZoom(true)
        binding.webView.settings.builtInZoomControls = true
        binding.webView.settings.displayZoomControls = true
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(url)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFinishAfterTransition()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_news, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item?.itemId

        if (id == R.id.webView) {
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(mUrl)
            startActivity(i)
            return true
        } else if (id == R.id.share) {

            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plan"
            i.putExtra(Intent.EXTRA_SUBJECT, mSource)
            val body = "$mTitle\n$mUrl\nShare from the News App\n"
            i.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(i, "Share with :"))
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onOffsetChanged(p0: AppBarLayout?, p1: Int) {
        val maxScroll: Int = p0!!.totalScrollRange
        val percentage: Float = abs(p1).toFloat() / maxScroll.toFloat()

        if (percentage == 1f && isHideToolbarView) {
           binding.dateBehavior.visibility = View.GONE
            binding.titleAppbar.visibility = View.VISIBLE
            isHideToolbarView = !isHideToolbarView
        } else if (percentage < 1f && !isHideToolbarView) {
            binding.dateBehavior.visibility = View.VISIBLE
            binding.titleAppbar.visibility = View.GONE
            isHideToolbarView = !isHideToolbarView
        }
    }
}