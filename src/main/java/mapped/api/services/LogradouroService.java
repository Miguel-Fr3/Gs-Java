package mapped.api.services;

import mapped.api.models.entities.Logradouro;
import mapped.api.models.repositories.LogradouroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LogradouroService {
    private final LogradouroRepository logradouroRepository;

    public LogradouroService() {
        this.logradouroRepository = new LogradouroRepository();
    }

    public List<Logradouro> findAll() throws SQLException {
        return logradouroRepository.findAll();
    }

    public void add(Logradouro logradouro) throws SQLException {
        logradouroRepository.add(logradouro);
    }

    public Optional<Logradouro> find(String cdLogradouro) throws SQLException {
        return logradouroRepository.find(cdLogradouro);
    }

    public void update(String cdLogradouro, Logradouro logradouro) throws SQLException {
        logradouroRepository.update(cdLogradouro, logradouro);
    }

    public void delete(String cdLogradouro) throws SQLException {
        logradouroRepository.delete(cdLogradouro);
    }
}
