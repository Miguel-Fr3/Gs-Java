package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Atendimento;
import mapped.api.models.repositories.AtendimentoRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/atendimentos")
public class AtendimentoResource {
    private AtendimentoRepository repository = new AtendimentoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Atendimento> getAtendimentos() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAtendimento(Atendimento atendimento) throws SQLException {
        repository.add(atendimento);
    }

    @GET
    @Path("/{cdAtendimento}")
    @Produces(MediaType.APPLICATION_JSON)
    public Atendimento getAtendimentoByCd(@PathParam("cdAtendimento") String cdAtendimento) throws SQLException {
        return repository.find(cdAtendimento).orElse(null);
    }

    @PUT
    @Path("/{cdAtendimento}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Atendimento updateAtendimento(@PathParam("cdAtendimento") String cdAtendimento, Atendimento atendimento) throws SQLException {
        if (repository.find(cdAtendimento).isPresent()) {
            atendimento.setCdAtendimento(cdAtendimento);
            repository.update(cdAtendimento, atendimento);
            return repository.find(cdAtendimento).orElse(null);
        }
        return atendimento;
    }

    @DELETE
    @Path("/{cdAtendimento}")
    public void deleteAtendimento(@PathParam("cdAtendimento") String cdAtendimento) throws SQLException {
        if (repository.find(cdAtendimento).isPresent()) {
            repository.delete(cdAtendimento);
        }
    }
}
