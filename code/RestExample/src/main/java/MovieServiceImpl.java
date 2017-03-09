import java.util.List;

public class MovieServiceImpl implements MovieService
{
    DBUtil dbUtil = DBUtil.getInstance();

    @Override
    public List<Movie> getAllMovies()
    {
        return dbUtil.getAllMovies();
    }

    @Override
    public Movie getMovieById(long id)
    {
        return dbUtil.getMovieWithId(id);
    }

    @Override
    public void deleteMovieById(long id)
    {
        dbUtil.deleteMovieWithId(id);
    }

    @Override
    public void createMovie(Movie movie)
    {
        dbUtil.createNewMovie(movie);
    }
}
