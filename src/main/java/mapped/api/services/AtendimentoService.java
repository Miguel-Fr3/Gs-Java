package mapped.api.services;

import mapped.api.models.entities.Atendimento;
import mapped.api.models.repositories.AtendimentoRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AtendimentoService {
    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService() {
        this.atendimentoRepository = new AtendimentoRepository();
    }

    public List<Atendimento> findAll() throws SQLException {
        return atendimentoRepository.findAll();
    }

    public void add(Atendimento atendimento) throws SQLException {
        atendimentoRepository.add(atendimento);
    }

    public Optional<Atendimento> find(String cdAtendimento) throws SQLException {
        return atendimentoRepository.find(cdAtendimento);
    }

    public void update(String cdAtendimento, Atendimento atendimento) throws SQLException {
        atendimentoRepository.update(cdAtendimento, atendimento);
    }

    public void delete(String cdAtendimento) throws SQLException {
        atendimentoRepository.delete(cdAtendimento);
    }
}
