package com.example.notepad.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.notepad.R
import de.hdodenhof.circleimageview.CircleImageView


class TimelinePostAdapter : RecyclerView.Adapter<TimelinePostAdapter.PostViewHolder>() {
    private var context: Context? = null
    private var posts: ArrayList<TimelinePost>? = null

    fun TimelinePostAdapter(context: Context?, posts: ArrayList<TimelinePost>?) {
        this.context = context
        this.posts = posts
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PostViewHolder {
        return PostViewHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.home_post_layout, viewGroup, false)
        )
    }

    override fun onBindViewHolder(postViewHolder: PostViewHolder, i: Int) {
        val post: TimelinePost = posts!![i]
        context?.let {
            Glide.with(it)
                .load(post.getProfilePic())
                .into(postViewHolder.profilePic)
        }
        context?.let {
            Glide.with(it)
                .load(post.getImageUrl())
                .into(postViewHolder.imgPost)
        }
        postViewHolder.tvName.setText(post.getName())
        postViewHolder.tvLikes.setText(post.getLikes().toString() + " likes")
        postViewHolder.tvCaption.setText(post.getCaption())
        postViewHolder.tvDate.setText(post.getDate())
    }

    override fun getItemCount(): Int {
        return if (posts != null) {
            posts!!.size
        } else 0
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var profilePic: CircleImageView
        var tvName: TextView
        var imgPost: ImageView
        var tvLikes: TextView
        var tvCaption: TextView
        var tvDate: TextView

        init {
            profilePic = itemView.findViewById(R.id.profile_image)
            tvName = itemView.findViewById(R.id.tvName)
            imgPost = itemView.findViewById(R.id.imgPost)
            tvLikes = itemView.findViewById(R.id.tvLikes)
            tvCaption = itemView.findViewById(R.id.tvCaption)
            tvDate = itemView.findViewById(R.id.tvDate)
        }
    }
}