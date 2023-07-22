package com.c2r.movies.ui.movie

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.c2r.movies.R
import com.c2r.movies.application.AppConstants
import com.c2r.movies.core.Resource
import com.c2r.movies.data.model.MovieUI
import com.c2r.movies.data.remote.MovieDataSource
import com.c2r.movies.databinding.FragmentMovieBinding
import com.c2r.movies.presentation.MovieViewModel
import com.c2r.movies.presentation.MovieViewModelFactory
import com.c2r.movies.repository.MovieRepositoryImp
import com.c2r.movies.repository.RetrofitClient
import com.c2r.movies.ui.movie.adapters.MovieAdapter
import com.c2r.movies.ui.movie.adapters.concat.PopularConcatAdapter
import com.c2r.movies.ui.movie.adapters.concat.TopRateConcatAdapter
import com.c2r.movies.ui.movie.adapters.concat.UpcomingConcatAdapter


class MovieFragment : Fragment(R.layout.fragment_movie), MovieAdapter.OnMovieClickListener {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> {
        MovieViewModelFactory(
            MovieRepositoryImp(
                MovieDataSource(RetrofitClient.webservice)
            )
        )
    }
    private lateinit var concatAdapter: ConcatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        concatAdapter = ConcatAdapter()

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    Log.d("VER", "Loading...")
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    Log.d("VER1", "${it.data.first}")
                    binding.progressBar.visibility = View.GONE
                    concatAdapter.apply {
                        addAdapter(
                            0,
                            UpcomingConcatAdapter(
                                MovieAdapter(
                                    it.data.first.data,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            1,
                            TopRateConcatAdapter(
                                MovieAdapter(
                                    it.data.second.data,
                                    this@MovieFragment
                                )
                            )
                        )
                        addAdapter(
                            2,
                            PopularConcatAdapter(
                                MovieAdapter(
                                    it.data.third.data,
                                    this@MovieFragment
                                )
                            )
                        )
                    }

                    binding.rvMovies.adapter = concatAdapter
                }
                is Resource.Failure -> {
                    binding.progressBar.visibility = View.GONE
                    Log.d("Error", "${it.exception}")
                }
            }
        }

    }


    override fun onMovieClick(movieUI: MovieUI) {
        val action = MovieFragmentDirections.actionMovieFragmentToMovieDetailFragment(
            movieUI.imgMovie,
            movieUI.imgBackground,
            movieUI.title,
            movieUI.voteAverage.toFloat(),
            movieUI.voteCount,
            movieUI.description,
            movieUI.language,
            movieUI.release
        )
        findNavController().navigate(action)
    }
}