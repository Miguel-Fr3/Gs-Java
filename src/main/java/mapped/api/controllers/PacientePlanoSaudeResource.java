package mapped.api.controllers;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mapped.api.models.entities.PacientePlanoSaude;
import mapped.api.models.repositories.PacientePlanoSaudeRepository;

import java.sql.SQLException;
import java.util.List;

@Path("/pacientes-planos-saude")
public class PacientePlanoSaudeResource {
    private PacientePlanoSaudeRepository repository = new PacientePlanoSaudeRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PacientePlanoSaude> getPacientesPlanosSaude() throws SQLException {
        return repository.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addPacientePlanoSaude(PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        repository.add(pacientePlanoSaude);
    }

    @GET
    @Path("/{cdPlanoPaciente}")
    @Produces(MediaType.APPLICATION_JSON)
    public PacientePlanoSaude getPacientePlanoSaudeByCd(@PathParam("cdPlanoPaciente") String cdPlanoPaciente) throws SQLException {
        return repository.find(cdPlanoPaciente).orElse(null);
    }

    @PUT
    @Path("/{cdPlanoPaciente}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PacientePlanoSaude updatePacientePlanoSaude(@PathParam("cdPlanoPaciente") String cdPlanoPaciente, PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        if (repository.find(cdPlanoPaciente).isPresent()) {
            pacientePlanoSaude.setCdPlanoPaciente(cdPlanoPaciente);
            repository.update(cdPlanoPaciente, pacientePlanoSaude);
            return repository.find(cdPlanoPaciente).orElse(null);
        }
        return pacientePlanoSaude;
    }

    @DELETE
    @Path("/{cdPlanoPaciente}")
    public void deletePacientePlanoSaude(@PathParam("cdPlanoPaciente") String cdPlanoPaciente) throws SQLException {
        if (repository.find(cdPlanoPaciente).isPresent()) {
            repository.delete(cdPlanoPaciente);
        }
    }
}
