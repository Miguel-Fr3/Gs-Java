package mapped.api.controllers;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Cidade;
import mapped.api.models.repositories.CidadeRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/cidades")
public class CidadeResource {
    private CidadeRepository repository = new CidadeRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cidade> getCidades() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCidade(Cidade cidade) throws SQLException {
        repository.add(cidade);
    }

    @GET
    @Path("/{cdCidade}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade getCidadeByCd(@PathParam("cdCidade") String cdCidade) throws SQLException {
        return repository.find(cdCidade).orElse(null);
    }

    @PUT
    @Path("/{cdCidade}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cidade updateCidade(@PathParam("cdCidade") String cdCidade, Cidade cidade) throws SQLException {
        if (repository.find(cdCidade).isPresent()) {
            cidade.setCdCidade(cdCidade);
            repository.update(cdCidade, cidade);
            return repository.find(cdCidade).orElse(null);
        }
        return cidade;
    }

    @DELETE
    @Path("/{cdCidade}")
    public void deleteCidade(@PathParam("cdCidade") String cdCidade) throws SQLException {
        if (repository.find(cdCidade).isPresent()) {
            repository.delete(cdCidade);
        }
    }
}
