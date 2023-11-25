package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Contato;
import mapped.api.models.repositories.ContatoRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/contatos")
public class ContatoResource {
    private ContatoRepository repository = new ContatoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contato> getContatos() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addContato(Contato contato) throws SQLException {
        repository.add(contato);
    }

    @GET
    @Path("/{cdContato}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contato getContatoByCd(@PathParam("cdContato") String cdContato) throws SQLException {
        return repository.find(cdContato).orElse(null);
    }

    @PUT
    @Path("/{cdContato}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Contato updateContato(@PathParam("cdContato") String cdContato, Contato contato) throws SQLException {
        if (repository.find(cdContato).isPresent()) {
            contato.setCdContato(Integer.parseInt(cdContato));
            repository.update(cdContato, contato);
            return repository.find(cdContato).orElse(null);
        }
        return contato;
    }

    @DELETE
    @Path("/{cdContato}")
    public void deleteContato(@PathParam("cdContato") String cdContato) throws SQLException {
        if (repository.find(cdContato).isPresent()) {
            repository.delete(cdContato);
        }
    }
}
