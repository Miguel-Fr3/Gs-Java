package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Bairro;
import mapped.api.models.repositories.BairroRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/bairros")
public class BairroResource {
    private BairroRepository repository = new BairroRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bairro> getBairros() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBairro(Bairro bairro) throws SQLException {
        repository.add(bairro);
    }

    @GET
    @Path("/{cdBairro}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bairro getBairroByCd(@PathParam("cdBairro") int cdBairro) throws SQLException {
        return repository.find(cdBairro).orElse(null);
    }

    @PUT
    @Path("/{cdBairro}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Bairro updateBairro(@PathParam("cdBairro") int cdBairro, Bairro bairro) throws SQLException {
        if (repository.find(cdBairro).isPresent()) {
            bairro.setCdBairro(cdBairro);
            repository.update(cdBairro, bairro);
            return repository.find(cdBairro).orElse(null);
        }
        return bairro;
    }

    @DELETE
    @Path("/{cdBairro}")
    public void deleteBairro(@PathParam("cdBairro") int cdBairro) throws SQLException {
        if (repository.find(cdBairro).isPresent()) {
            repository.delete(cdBairro);
        }
    }
}
