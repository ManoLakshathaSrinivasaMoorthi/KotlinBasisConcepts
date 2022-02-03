package com.example.notepad.newsapp.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.example.newsapp.model.Article
import com.example.notepad.R
import com.example.notepad.newsapp.NewsDetailActivity
import com.example.notepad.newsapp.Utils

class Adapter(private val context: Context, private val list: ArrayList<Article>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view,onItemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onItemClick(view: View?, position: Int) {

        }
    }
    private var onItemClickListener: OnItemClickListener? = null
    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model: Article = list[position]
        val utils = Utils()

        val requestOptions = RequestOptions()
        requestOptions.placeholder(utils.getRandomColor())
        requestOptions.error(utils.getRandomColor())
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL)
        requestOptions.centerCrop()


        Glide.with(context)
            .load(model.urlToImage)
            .apply(requestOptions)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    holder.progressBar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    holder.progressBar.visibility = View.GONE
                    return false
                }
            }).transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.imageView)

        holder.title.text = model.title
        holder.desc.text = model.description
        holder.source.text = model.source?.name
        holder.author.text = model.author
        holder.time.text = "\u2022 " + model.publishAt?.let { utils.dateFormat(it) }
        holder.publishedAt.text = utils.dateFormat(model.publishAt.toString())
        holder.itemView.setOnClickListener {
            val intent = Intent(context, NewsDetailActivity::class.java)

            intent.putExtra("url", model.url)
            intent.putExtra("title", model.title)
            intent.putExtra("img", model.urlToImage)
            intent.putExtra("date", model.publishAt)
            intent.putExtra("source", model.source?.name)
            intent.putExtra("author", model.author)


            val pair: Pair<View, String> = Pair(holder.imageView, ViewCompat.getTransitionName(holder.imageView))
            val optionsCompat: ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                context as Activity, pair
            )

            context.startActivity(intent, optionsCompat.toBundle())
        }
    }

    class ViewHolder(view: View, onItemClickListener: OnItemClickListener?) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {


        val title: TextView = view.findViewById(R.id.title)
        val desc: TextView = view.findViewById(R.id.desc)
        val author: TextView = view.findViewById(R.id.author)
        val publishedAt: TextView = view.findViewById(R.id.publishedAt)
        val source: TextView = view.findViewById(R.id.source)
        val time: TextView = view.findViewById(R.id.time)
        val imageView: ImageView = view.findViewById(R.id.img)
        val progressBar: ProgressBar = view.findViewById(R.id.prograss_load_photo  )

        private val onItemClickListeners = onItemClickListener

        override fun onClick(v: View?) {
            onItemClickListeners?.onItemClick(v, adapterPosition)
        }


    }

}