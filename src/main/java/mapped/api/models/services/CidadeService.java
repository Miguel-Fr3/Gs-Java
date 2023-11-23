package mapped.api.models.services;

import mapped.api.models.entities.Cidade;
import mapped.api.models.repositories.CidadeRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CidadeService {
    private final CidadeRepository cidadeRepository;

    public CidadeService() {
        this.cidadeRepository = new CidadeRepository();
    }

    public List<Cidade> findAll() throws SQLException {
        return cidadeRepository.findAll();
    }

    public void add(Cidade cidade) throws SQLException {
        cidadeRepository.add(cidade);
    }

    public Optional<Cidade> find(String cdCidade) throws SQLException {
        return cidadeRepository.find(cdCidade);
    }

    public void update(String cdCidade, Cidade cidade) throws SQLException {
        cidadeRepository.update(cdCidade, cidade);
    }

    public void delete(String cdCidade) throws SQLException {
        cidadeRepository.delete(cdCidade);
    }
}
