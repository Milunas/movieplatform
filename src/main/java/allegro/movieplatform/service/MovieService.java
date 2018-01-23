package allegro.movieplatform.service;

import allegro.movieplatform.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity<List<Movie>> getAllMovies();

    ResponseEntity<Void> addMovie(Movie movie);

    ResponseEntity<Movie> getMovieByTitle(String title);

}
