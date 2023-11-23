package mapped.api.models.services;

import mapped.api.models.entities.Contato;
import mapped.api.models.repositories.ContatoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ContatoService {
    private final ContatoRepository contatoRepository;

    public ContatoService() {
        this.contatoRepository = new ContatoRepository();
    }

    public List<Contato> findAll() throws SQLException {
        return contatoRepository.findAll();
    }

    public void add(Contato contato) throws SQLException {
        contatoRepository.add(contato);
    }

    public Optional<Contato> find(String cdContato) throws SQLException {
        return contatoRepository.find(cdContato);
    }

    public void update(String cdContato, Contato contato) throws SQLException {
        contatoRepository.update(cdContato, contato);
    }

    public void delete(String cdContato) throws SQLException {
        contatoRepository.delete(cdContato);
    }
}
