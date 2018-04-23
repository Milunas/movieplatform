package milunas.allegromovies.controller

import milunas.allegromovies.model.Movie
import milunas.allegromovies.service.MovieService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/movie")
class MovieController(private val movieService: MovieService) {

    @GetMapping
    fun getAllMovies() : List<Movie>{
        return movieService.getAllMovies()
    }

    @PostMapping
    fun addMovie(@RequestBody movie: Movie){
        movieService.addMovie(movie)
    }

    @GetMapping("/{id}")
    fun getMovieById(@PathVariable id: String) : Movie{
        return movieService.getMovieById(id.toLong())
    }

}