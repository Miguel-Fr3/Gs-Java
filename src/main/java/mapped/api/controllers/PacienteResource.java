package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.Paciente;
import mapped.api.models.repositories.PacienteRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/pacientes")
public class PacienteResource {
    private PacienteRepository repository = new PacienteRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> getPacientes() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPaciente(Paciente paciente) throws SQLException {
        repository.add(paciente);
    }

    @GET
    @Path("/{cdPaciente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente getPacienteByCd(@PathParam("cdPaciente") String cdPaciente) throws SQLException {
        return repository.find(Integer.parseInt(cdPaciente)).orElse(null);
    }

    @PUT
    @Path("/{cdPaciente}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente updatePaciente(@PathParam("cdPaciente") String cdPaciente, Paciente paciente) throws SQLException {
        if (repository.find(Integer.parseInt(cdPaciente)).isPresent()) {
            paciente.setCdPaciente(Integer.parseInt(cdPaciente));
            repository.update(Integer.parseInt(cdPaciente), paciente);
            return repository.find(Integer.parseInt(cdPaciente)).orElse(null);
        }
        return paciente;
    }

    @DELETE
    @Path("/{cdPaciente}")
    public void deletePaciente(@PathParam("cdPaciente") String cdPaciente) throws SQLException {
        if (repository.find(Integer.parseInt(cdPaciente)).isPresent()) {
            repository.delete(Integer.parseInt(cdPaciente));
        }
    }
}
