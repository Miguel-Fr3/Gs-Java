package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.PlanoSaude;
import mapped.api.models.repositories.PlanoSaudeRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/planos-saude")
public class PlanoSaudeResource {
    private PlanoSaudeRepository repository = new PlanoSaudeRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlanoSaude> getPlanosSaude() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPlanoSaude(PlanoSaude planoSaude) throws SQLException {
        repository.add(planoSaude);
    }

    @GET
    @Path("/{cdPlanoSaude}")
    @Produces(MediaType.APPLICATION_JSON)
    public PlanoSaude getPlanoSaudeByCd(@PathParam("cdPlanoSaude") String cdPlanoSaude) throws SQLException {
        return repository.find(cdPlanoSaude).orElse(null);
    }

    @PUT
    @Path("/{cdPlanoSaude}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PlanoSaude updatePlanoSaude(@PathParam("cdPlanoSaude") String cdPlanoSaude, PlanoSaude planoSaude) throws SQLException {
        if (repository.find(cdPlanoSaude).isPresent()) {
            planoSaude.setCdPlanoSaude(Integer.valueOf(cdPlanoSaude));
            repository.update(cdPlanoSaude, planoSaude);
            return repository.find(cdPlanoSaude).orElse(null);
        }
        return planoSaude;
    }

    @DELETE
    @Path("/{cdPlanoSaude}")
    public void deletePlanoSaude(@PathParam("cdPlanoSaude") String cdPlanoSaude) throws SQLException {
        if (repository.find(cdPlanoSaude).isPresent()) {
            repository.delete(cdPlanoSaude);
        }
    }
}
