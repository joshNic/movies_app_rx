package com.example.mvvmrx.single_movie_details

import androidx.lifecycle.LiveData
import com.example.mvvmrx.data.api.TheMovieDBInterface
import com.example.mvvmrx.data.repository.MovieDetailsNetworkDataSource
import com.example.mvvmrx.data.repository.NetworkState
import com.example.mvvmrx.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService:TheMovieDBInterface){
    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource
    fun fetchSingleMovieDetails(compositeDisposable: CompositeDisposable, movieId:Int):LiveData<MovieDetails>{
        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService, compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)
        return movieDetailsNetworkDataSource.downloadedMovieDetailsResponse
    }
    fun getMovieDetailsNetworkState():LiveData<NetworkState>{
        return movieDetailsNetworkDataSource.networkState
    }
}