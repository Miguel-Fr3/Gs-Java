package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Logradouro;
import mapped.api.models.repositories.LogradouroRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/logradouros")
public class LogradouroResource {
    private LogradouroRepository repository = new LogradouroRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logradouro> getLogradouros() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLogradouro(Logradouro logradouro) throws SQLException {
        repository.add(logradouro);
    }

    @GET
    @Path("/{cdLogradouro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Logradouro getLogradouroByCd(@PathParam("cdLogradouro") String cdLogradouro) throws SQLException {
        return repository.find(cdLogradouro).orElse(null);
    }

    @PUT
    @Path("/{cdLogradouro}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Logradouro updateLogradouro(@PathParam("cdLogradouro") String cdLogradouro, Logradouro logradouro) throws SQLException {
        if (repository.find(cdLogradouro).isPresent()) {
            logradouro.setCdLogradouro(Integer.parseInt(cdLogradouro));
            repository.update(cdLogradouro, logradouro);
            return repository.find(cdLogradouro).orElse(null);
        }
        return logradouro;
    }

    @DELETE
    @Path("/{cdLogradouro}")
    public void deleteLogradouro(@PathParam("cdLogradouro") String cdLogradouro) throws SQLException {
        if (repository.find(cdLogradouro).isPresent()) {
            repository.delete(cdLogradouro);
        }
    }
}
