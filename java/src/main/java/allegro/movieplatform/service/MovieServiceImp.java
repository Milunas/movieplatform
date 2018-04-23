package allegro.movieplatform.service;

import allegro.movieplatform.model.Movie;
import allegro.movieplatform.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    private final static String BASE_URL = "localhost:8080/movies/";

    @Autowired
    private MovieRepository repository;

     public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = repository.findAll();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    public ResponseEntity<Void> addMovie(Movie movie) {
        repository.save(movie);
        HttpHeaders responseHeaders = new HttpHeaders();
        String location = BASE_URL + movie.getTitle();
        responseHeaders.set("Location", location);
        return new ResponseEntity<>(responseHeaders, HttpStatus.CREATED);

    }

    public ResponseEntity<Movie> getMovieByTitle(String title){
         Movie movie = repository.findMovieByTitle(title);
         if (movie==null) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
         return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}
