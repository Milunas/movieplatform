package allegro.movieplatform.controller;

import allegro.movieplatform.model.Movie;
import allegro.movieplatform.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/movies")
     ResponseEntity<List<Movie>> getAllMovies(){
        return service.getAllMovies();
    }

    @PostMapping("/movies")
     ResponseEntity<Void> addMovie(@RequestBody Movie movie){
      return service.addMovie(movie);
    }

    @GetMapping("/movies/{title}")
    ResponseEntity<Movie> getMovie(@PathVariable String title){
        return service.getMovieByTitle(title);
    }
}
