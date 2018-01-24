package allegro.movieplatform.controller;

import allegro.movieplatform.model.Movie;
import allegro.movieplatform.service.MovieService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/movies")
    @ApiOperation(value = "Find all movies",
            response = Movie.class,
            responseContainer = "List",
            httpMethod = "GET")
     ResponseEntity<List<Movie>> getAllMovies(){
        return service.getAllMovies();
    }

    @PostMapping("/movies")
    @ApiOperation(value = "Add movie",
            httpMethod = "POST")
    ResponseEntity<Void> addMovie(@RequestBody Movie movie){
        return service.addMovie(movie);
    }

    @GetMapping("/movies/{title}")
    @ApiOperation(value = "Find movie by title",
            response = Movie.class,
            httpMethod = "GET")
    ResponseEntity<Movie> getMovie(@PathVariable String title){
        return service.getMovieByTitle(title);
    }
}
