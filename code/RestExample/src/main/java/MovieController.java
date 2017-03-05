import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "movies" )
public class MovieController
{
    private MovieService movieService = new MovieService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMovies()
    {
        System.out.println("Begin lookup for all movies in database");
        List<Movie> resultList = movieService.getAllMovies();
        GenericEntity<List<Movie>> entity = new GenericEntity<List<Movie>>(resultList){};
        return Response.ok(entity).build();
    }

    @GET
    @Path("{movieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("movieId") long movieId)
    {
        System.out.println("Begin lookup for movie with id " + movieId + " in database");
        return Response.ok(movieService.getMovieById(movieId)).build();
    }

    @DELETE
    @Path("{movieId}")
    public Response deleteMovieById(@PathParam("movieId") long movieId)
    {
        System.out.println("Begin lookup for movie with id " + movieId + " in database");
        movieService.deleteMovieById(movieId);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMovie(Movie movie)
    {
        System.out.println("Create movie with id: " + movie.getMovieId());
        movieService.createMovie(movie);
        return Response.status(Response.Status.CREATED).build();
    }
}


