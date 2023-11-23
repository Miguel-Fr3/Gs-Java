package mapped.api.services;

import mapped.api.models.entities.PlanoSaude;
import mapped.api.models.repositories.PlanoSaudeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PlanoSaudeService {
    private final PlanoSaudeRepository planoSaudeRepository;

    public PlanoSaudeService() {
        this.planoSaudeRepository = new PlanoSaudeRepository();
    }

    public List<PlanoSaude> findAll() throws SQLException {
        return planoSaudeRepository.findAll();
    }

    public void add(PlanoSaude planoSaude) throws SQLException {
        planoSaudeRepository.add(planoSaude);
    }

    public Optional<PlanoSaude> find(String cdPlanoSaude) throws SQLException {
        return planoSaudeRepository.find(cdPlanoSaude);
    }

    public void update(String cdPlanoSaude, PlanoSaude planoSaude) throws SQLException {
        planoSaudeRepository.update(cdPlanoSaude, planoSaude);
    }

    public void delete(String cdPlanoSaude) throws SQLException {
        planoSaudeRepository.delete(cdPlanoSaude);
    }
}
