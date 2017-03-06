import java.util.List;

public interface MovieService
{
    //retrieves all movies from db
    List<Movie> getAllMovies();

    //retrieves the specified movie from db
    Movie getMovieById(long id);

    //deletes the specified movie from db
    void deleteMovieById(long id);

    //creates a new movie in db
    void createMovie(Movie movie);
}
