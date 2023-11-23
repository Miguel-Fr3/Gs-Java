package mapped.api.controllers;

import mapped.api.models.entities.Login;
import mapped.api.models.repositories.LoginRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/login")
public class LoginResource {
    private LoginRepository repository = new LoginRepository();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLogin(Login login) throws SQLException {
        repository.add(login);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLogin(@QueryParam("cdLogin") String cdLogin,
                              @QueryParam("dsSenha") String dsSenha) throws SQLException {
        var foundLogin = repository.find(cdLogin, dsSenha);
        if (foundLogin.isPresent()) {
            return Response.status(Response.Status.OK).entity(foundLogin.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{cdLogin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoginByCdLogin(@PathParam("cdLogin") String cdLogin) throws SQLException {
        var foundLogin = repository.find(cdLogin, null); // Assuming dsSenha is not required for this query
        if (foundLogin.isPresent()) {
            return Response.status(Response.Status.OK).entity(foundLogin.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{cdLogin}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLogin(@PathParam("cdLogin") String cdLogin, Login login) throws SQLException {
        var existingLogin = repository.find(cdLogin, null); // Assuming dsSenha is not required for this query
        if (existingLogin.isPresent()) {
            repository.update(login);
            var updatedLogin = repository.find(cdLogin, null); // Assuming dsSenha is not required for this query
            return Response.status(Response.Status.OK).entity(updatedLogin.get()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).entity(login).build();
    }

    @DELETE
    @Path("{cdLogin}")
    public Response deleteLogin(@PathParam("cdLogin") String cdLogin) throws SQLException {
        var existingLogin = repository.find(cdLogin, null); // Assuming dsSenha is not required for this query
        if (existingLogin.isPresent()) {
            repository.delete(cdLogin);
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
