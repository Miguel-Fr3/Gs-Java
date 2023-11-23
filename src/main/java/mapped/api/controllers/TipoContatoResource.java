package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.TipoContato;
import mapped.api.models.repositories.TipoContatoRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/tipos-contato")
public class TipoContatoResource {
    private TipoContatoRepository repository = new TipoContatoRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoContato> getTiposContato() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTipoContato(TipoContato tipoContato) throws SQLException {
        repository.add(tipoContato);
    }

    @GET
    @Path("/{cdTipoContato}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoContato getTipoContatoByCd(@PathParam("cdTipoContato") String cdTipoContato) throws SQLException {
        return repository.find(cdTipoContato).orElse(null);
    }

    @PUT
    @Path("/{cdTipoContato}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TipoContato updateTipoContato(@PathParam("cdTipoContato") String cdTipoContato, TipoContato tipoContato) throws SQLException {
        if (repository.find(cdTipoContato).isPresent()) {
            tipoContato.setCdTipoContato(cdTipoContato);
            repository.update(cdTipoContato, tipoContato);
            return repository.find(cdTipoContato).orElse(null);
        }
        return tipoContato;
    }

    @DELETE
    @Path("/{cdTipoContato}")
    public void deleteTipoContato(@PathParam("cdTipoContato") String cdTipoContato) throws SQLException {
        if (repository.find(cdTipoContato).isPresent()) {
            repository.delete(cdTipoContato);
        }
    }
}
