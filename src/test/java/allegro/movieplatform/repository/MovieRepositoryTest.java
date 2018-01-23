package allegro.movieplatform.repository;

import allegro.movieplatform.model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MovieRepositoryTest {

    @Autowired
    protected MovieRepository repository;

    private final String EXAMPLE = "Example";

    @Before
    public void setUp(){
        repository.save(new Movie(EXAMPLE));
    }

    @Test
    public void findMovieExampleByTitle(){
        //when
        Movie result = repository.findMovieByTitle(EXAMPLE);
        //then
        Assert.assertNotNull(result);
        Assert.assertEquals(EXAMPLE, result.getTitle());
    }

    @Test
    public void findMovieByTitleNegative(){
        //when
        Movie result = repository.findMovieByTitle("NotExisting"+EXAMPLE);
        //then
        Assert.assertNull(result);
    }
}
