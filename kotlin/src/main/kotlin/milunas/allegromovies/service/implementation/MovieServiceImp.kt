package milunas.allegromovies.service.implementation

import milunas.allegromovies.model.Movie
import milunas.allegromovies.repository.MovieRepository
import milunas.allegromovies.service.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MovieServiceImp(private val movieRepository: MovieRepository) : MovieService{

    override fun getAllMovies() : List<Movie> {
        return movieRepository.findAll()
    }

    override fun getMovieById(id: Long): Movie {
        return movieRepository.findById(id).get()
    }

    override fun addMovie(movie: Movie)  {
        if(isMoviePresent(movie))
            movieRepository.save(movie)
        else
            throw RuntimeException("Movie " + movie.title + " already in database")
    }

    private fun isMoviePresent(movie: Movie) : Boolean{
        return movieRepository.findByTitle(movie.title).isPresent
    }

}