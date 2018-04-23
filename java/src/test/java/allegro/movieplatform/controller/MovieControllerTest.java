package allegro.movieplatform.controller;

import allegro.movieplatform.MoviePlatformApplication;
import allegro.movieplatform.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
                classes = MoviePlatformApplication.class)
public class MovieControllerTest {

    @LocalServerPort
    private Integer port;
    @Autowired
    private MovieController controller;
    private final String EXAMPLE = "Example";

    @Before
    public void setUp(){
        controller.addMovie(new Movie(EXAMPLE));
    }

    @Test
    public void shouldGetExampleMovieByTitle(){
        given()
                .port(port)
        .when()
                .get("/movies/"+EXAMPLE)
        .then()
                .log().all()
                .assertThat()
                    .statusCode(200)
                    .body("title", is(EXAMPLE));
    }
}
