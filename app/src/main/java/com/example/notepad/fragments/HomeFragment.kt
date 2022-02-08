package com.example.notepad.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notepad.R
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.notepad.MainActivity



import androidx.annotation.NonNull
import androidx.annotation.Nullable

import androidx.recyclerview.widget.RecyclerView




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var rvPosts: RecyclerView? = null
    private var postAdapter: TimelinePostAdapter? = null
    private var posts: ArrayList<TimelinePost>? = null

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        posts = ArrayList()
        rvPosts = view.findViewById(R.id.rvPosts)

        //Populating posts
        posts!!.add(
            TimelinePost(
                MainActivity.images.get(0),
                "schwarzenegger",
                MainActivity.images.get(1),
                112,
                "How is that UI boy?",
                "10 min ago"
            )
        )
        posts!!.add(
            TimelinePost(
                MainActivity.images.get(3),
                "Conor McGregor",
                MainActivity.images.get(3),
                200,
                "World Champion!",
                "2 hr ago"
            )
        )
        rvPosts.setLayoutManager(LinearLayoutManager(context))
        postAdapter = TimelinePostAdapter(context, posts)
        rvPosts.setAdapter(postAdapter)
    }
}