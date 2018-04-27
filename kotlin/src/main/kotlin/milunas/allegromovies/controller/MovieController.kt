package milunas.allegromovies.controller

import milunas.allegromovies.model.Movie
import milunas.allegromovies.service.MovieService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/movie")
class MovieController(private val movieService: MovieService) {

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun getAllMovies() : List<Movie>{
        return movieService.getAllMovies()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addMovie(@RequestBody movie: Movie) {
        val addedMovie = movieService.addMovie(movie)
        HttpHeaders().set("Location", addedMovie.id.toString())
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun getMovieById(@PathVariable id: String) : Movie{
        return movieService.getMovieById(id.toLong())
    }

}