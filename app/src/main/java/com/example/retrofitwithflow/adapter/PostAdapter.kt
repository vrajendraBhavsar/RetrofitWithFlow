package com.example.retrofitwithflow.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithflow.databinding.EachRowBinding
import com.example.retrofitwithflow.model.Post

class PostAdapter(private var postList: ArrayList<Post>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = EachRowBinding.inflate(LayoutInflater.from(parent.context) , parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val singlePostList: Post = postList[position] //getting one item from list
        holder.bind(singlePostList)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    fun setPostData(postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }

    inner class PostViewHolder(var viewBinding: EachRowBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(singlePost: Post) {
            viewBinding.tvBody.text = singlePost.body
        }
    }
}