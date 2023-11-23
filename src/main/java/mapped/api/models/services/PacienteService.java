package mapped.api.models.services;

import mapped.api.models.entities.Paciente;
import mapped.api.models.repositories.PacienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService() {
        this.pacienteRepository = new PacienteRepository();
    }

    public List<Paciente> findAll() throws SQLException {
        return pacienteRepository.findAll();
    }

    public void add(Paciente paciente) throws SQLException {
        pacienteRepository.add(paciente);
    }

    public Optional<Paciente> find(String cdPaciente) throws SQLException {
        return pacienteRepository.find(cdPaciente);
    }

    public void update(String cdPaciente, Paciente paciente) throws SQLException {
        pacienteRepository.update(cdPaciente, paciente);
    }

    public void delete(String cdPaciente) throws SQLException {
        pacienteRepository.delete(cdPaciente);
    }
}
