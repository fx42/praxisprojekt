import java.util.List;

public class MovieServiceImpl implements MovieService
{
    DBUtil dbUtil = DBUtil.getInstance();

    @Override
    public List<Movie> getAllMovies()
    {
        System.out.println("get for all movies is performed");
        //Here happens the Database interaction
        return dbUtil.getAllMovies();
    }

    @Override
    public Movie getMovieById(long id)
    {
        System.out.println("get for movie with id " + id + " is performed");
        //Here happens the Database interaction
        return dbUtil.getMovieWithId(id);
    }

    @Override
    public void deleteMovieById(long id)
    {
        System.out.println("delete for movie with id " + id + " is performed");
        //Here happens the Database interaction
        dbUtil.deleteMovieWithId(id);
    }

    @Override
    public void createMovie(Movie movie)
    {
        System.out.println("new movie with id " + movie.getMovieId() + "is created");
        //Here happens the Database interaction
        dbUtil.createNewMovie(movie);
    }
}