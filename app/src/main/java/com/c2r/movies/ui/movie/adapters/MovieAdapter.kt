package com.c2r.movies.ui.movie.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.c2r.movies.application.AppConstants
import com.c2r.movies.core.BaseViewHolder
import com.c2r.movies.data.model.MovieUI
import com.c2r.movies.databinding.MovieItemBinding

class MovieAdapter(
    private val moviesList: List<MovieUI>,
    private val itemClickListener: OnMovieClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnMovieClickListener {
        fun onMovieClick(movieUI: MovieUI)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = MoviesViewHolder(itemBinding, parent.context)

        itemBinding.root.setOnClickListener {
            val position =
                holder.bindingAdapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                    ?: return@setOnClickListener
            itemClickListener.onMovieClick(moviesList[position])
        }
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MoviesViewHolder -> holder.bind(moviesList[position])
        }
    }

    override fun getItemCount(): Int = moviesList.size

    private inner class MoviesViewHolder(
        val binding: MovieItemBinding,
        val context: Context
    ) :
        BaseViewHolder<MovieUI>(binding.root) {
        override fun bind(item: MovieUI) {
            Glide.with(context).load("${AppConstants.BASE_URL_IMAGE}${item.imgMovie}")
                .centerCrop().into(binding.imgMovie)
        }

    }

}