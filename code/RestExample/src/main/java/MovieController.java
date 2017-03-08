import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.RequestWrapper;
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
        System.out.println("Begin lookup for all movies in database");
        List<Movie> resultList = movieService.getAllMovies();
        return Response.ok(gson.toJson(resultList)).build();
    }

    @GET
    @Path("{movieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("movieId") long movieId)
    {
        Gson gson = new Gson();
        System.out.println("Begin lookup for movie with id " + movieId + " in database");
        return Response.ok(gson.toJson(movieService.getMovieById(movieId))).build();
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
    public Response createMovie(Movie movie)
    {
        System.out.println("Create new movie in database");
        return Response.status(Response.Status.CREATED).build();
    }
}


