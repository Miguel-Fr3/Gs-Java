package mapped.api.models.services;

import mapped.api.models.entities.TipoContato;
import mapped.api.models.repositories.TipoContatoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TipoContatoService {
    private final TipoContatoRepository tipoContatoRepository;

    public TipoContatoService() {
        this.tipoContatoRepository = new TipoContatoRepository();
    }

    public List<TipoContato> findAll() throws SQLException {
        return tipoContatoRepository.findAll();
    }

    public void add(TipoContato tipoContato) throws SQLException {
        tipoContatoRepository.add(tipoContato);
    }

    public Optional<TipoContato> find(String cdTipoContato) throws SQLException {
        return tipoContatoRepository.find(cdTipoContato);
    }

    public void update(String cdTipoContato, TipoContato tipoContato) throws SQLException {
        tipoContatoRepository.update(cdTipoContato, tipoContato);
    }

    public void delete(String cdTipoContato) throws SQLException {
        tipoContatoRepository.delete(cdTipoContato);
    }
}
