package mapped.api.models.services;

import mapped.api.models.entities.PacientePlanoSaude;
import mapped.api.models.repositories.PacientePlanoSaudeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PacientePlanoSaudeService {
    private final PacientePlanoSaudeRepository pacientePlanoSaudeRepository;

    public PacientePlanoSaudeService() {
        this.pacientePlanoSaudeRepository = new PacientePlanoSaudeRepository();
    }

    public List<PacientePlanoSaude> findAll() throws SQLException {
        return pacientePlanoSaudeRepository.findAll();
    }

    public void add(PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        pacientePlanoSaudeRepository.add(pacientePlanoSaude);
    }

    public Optional<PacientePlanoSaude> find(String cdPlanoPaciente) throws SQLException {
        return pacientePlanoSaudeRepository.find(cdPlanoPaciente);
    }

    public void update(String cdPlanoPaciente, PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        pacientePlanoSaudeRepository.update(cdPlanoPaciente, pacientePlanoSaude);
    }

    public void delete(String cdPlanoPaciente) throws SQLException {
        pacientePlanoSaudeRepository.delete(cdPlanoPaciente);
    }
}
