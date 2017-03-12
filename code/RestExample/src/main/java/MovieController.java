import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path( "movies" )
public class MovieController
{
    private MovieService movieService = new MovieServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMovies()
    {
        Gson gson = new Gson();
        List<Movie> resultList = movieService.getAllMovies();
        return Response.ok(gson.toJson(resultList)).build();
    }

    @GET
    @Path("{movieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("movieId") long movieId)
    {
        Gson gson = new Gson();
        return Response.ok(gson.toJson(movieService.getMovieById(movieId))).build();
    }

    @DELETE
    @Path("{movieId}")
    public Response deleteMovieById(@PathParam("movieId") long movieId)
    {
        movieService.deleteMovieById(movieId);
        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMovie(Movie movie)
    {
        movieService.createMovie(movie);
        return Response.status(Response.Status.CREATED).build();
    }
}


