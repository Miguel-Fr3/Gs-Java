package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mapped.api.models.entities.Login;
import mapped.api.models.repositories.LoginRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/login")
public class LoginResource {
    private final LoginRepository repository = new LoginRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogins() {
        try {
            List<Login> logins = repository.findAll();
            if (!logins.isEmpty()) {
                return Response.status(Response.Status.OK).entity(logins).build();
            } else {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno ao buscar logins").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLogin(Login login) {
        try {
            repository.add(login);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno ao adicionar login").build();
        }
    }

    @GET
    @Path("{cdLogin}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLoginByCdLogin(@PathParam("cdLogin") String cdLogin) {
        try {
            if (cdLogin != null) {
                var foundLogin = repository.find(cdLogin, null);
                if (foundLogin.isPresent()) {
                    return Response.status(Response.Status.OK).entity(foundLogin.get()).build();
                }
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Parâmetro cdLogin não pode ser nulo").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno ao buscar login por cdLogin").build();
        }
    }

    @PUT
    @Path("{cdLogin}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLogin(@PathParam("cdLogin") String cdLogin, Login login) {
        try {
            if (cdLogin != null && login != null) {
                var existingLogin = repository.find(cdLogin, null);
                if (existingLogin.isPresent()) {
                    repository.update(login);
                    var updatedLogin = repository.find(cdLogin, null);
                    return Response.status(Response.Status.OK).entity(updatedLogin.get()).build();
                }
                return Response.status(Response.Status.NOT_FOUND).entity(login).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Parâmetros cdLogin ou login não podem ser nulos").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno ao atualizar login").build();
        }
    }

    @DELETE
    @Path("{cdLogin}")
    public Response deleteLogin(@PathParam("cdLogin") String cdLogin) {
        try {
            if (cdLogin != null) {
                var existingLogin = repository.find(cdLogin, null);
                if (existingLogin.isPresent()) {
                    repository.delete(cdLogin);
                    return Response.status(Response.Status.NO_CONTENT).build();
                }
                return Response.status(Response.Status.NOT_FOUND).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity("Parâmetro cdLogin não pode ser nulo").build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno ao excluir login").build();
        }
    }
}
