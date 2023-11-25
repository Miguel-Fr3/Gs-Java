package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.EnderecoPaciente;
import mapped.api.models.repositories.EnderecoPacienteRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/enderecos-pacientes")
public class EnderecoPacienteResource {
    private EnderecoPacienteRepository repository = new EnderecoPacienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnderecoPaciente> getEnderecosPacientes() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEnderecoPaciente(EnderecoPaciente enderecoPaciente) throws SQLException {
        repository.add(enderecoPaciente);
    }

    @GET
    @Path("/{cdEndereco}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoPaciente getEnderecoPacienteByCd(@PathParam("cdEndereco") String cdEndereco) throws SQLException {
        return repository.find(cdEndereco).orElse(null);
    }

    @PUT
    @Path("/{cdEndereco}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoPaciente updateEnderecoPaciente(@PathParam("cdEndereco") int cdEndereco, EnderecoPaciente enderecoPaciente) throws SQLException {
        if (repository.find(String.valueOf(cdEndereco)).isPresent()) {
            enderecoPaciente.setCdEndereco(cdEndereco);
            repository.update(String.valueOf(cdEndereco), enderecoPaciente);
            return repository.find(String.valueOf(cdEndereco)).orElse(null);
        }
        return enderecoPaciente;
    }

    @DELETE
    @Path("/{cdEndereco}")
    public void deleteEnderecoPaciente(@PathParam("cdEndereco") String cdEndereco) throws SQLException {
        if (repository.find(cdEndereco).isPresent()) {
            repository.delete(cdEndereco);
        }
    }
}
