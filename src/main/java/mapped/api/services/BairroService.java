package mapped.api.services;

import mapped.api.models.entities.Bairro;
import mapped.api.models.repositories.BairroRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BairroService {
    private final BairroRepository bairroRepository;

    public BairroService() {
        this.bairroRepository = new BairroRepository();
    }

    public List<Bairro> findAll() throws SQLException {
        return bairroRepository.findAll();
    }

    public void add(Bairro bairro) throws SQLException {
        bairroRepository.add(bairro);
    }

    public Optional<Bairro> find(int cdBairro) throws SQLException {
        return bairroRepository.find(cdBairro);
    }

    public void update(int cdBairro, Bairro bairro) throws SQLException {
        bairroRepository.update(cdBairro, bairro);
    }

    public void delete(int cdBairro) throws SQLException {
        bairroRepository.delete(cdBairro);
    }
}
