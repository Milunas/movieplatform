package milunas.allegromovies.service

import milunas.allegromovies.model.Movie

interface MovieService {

    fun getAllMovies() : List<Movie>

    fun getMovieById(id: Long) : Movie

    fun addMovie(movie: Movie)
}