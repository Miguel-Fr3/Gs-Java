package mapped.api.models.services;

import mapped.api.models.entities.EnderecoPaciente;
import mapped.api.models.repositories.EnderecoPacienteRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EnderecoPacienteService {
    private final EnderecoPacienteRepository enderecoPacienteRepository;

    public EnderecoPacienteService() {
        this.enderecoPacienteRepository = new EnderecoPacienteRepository();
    }

    public List<EnderecoPaciente> findAll() throws SQLException {
        return enderecoPacienteRepository.findAll();
    }

    public void add(EnderecoPaciente enderecoPaciente) throws SQLException {
        enderecoPacienteRepository.add(enderecoPaciente);
    }

    public Optional<EnderecoPaciente> find(String cdEndereco) throws SQLException {
        return enderecoPacienteRepository.find(cdEndereco);
    }

    public void update(String cdEndereco, EnderecoPaciente enderecoPaciente) throws SQLException {
        enderecoPacienteRepository.update(cdEndereco, enderecoPaciente);
    }

    public void delete(String cdEndereco) throws SQLException {
        enderecoPacienteRepository.delete(cdEndereco);
    }
}
