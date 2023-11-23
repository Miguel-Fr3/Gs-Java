package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Atendimento;
import mapped.api.models.entities.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AtendimentoRepository {

    public List<Atendimento> findAll() throws SQLException {
        List<Atendimento> atendimentos = new ArrayList<>();
        String sql = "SELECT * FROM tabela_atendimento";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                atendimentos.add(mapResultSetToAtendimento(results));
            }
        }
        return atendimentos;
    }

    public void add(Atendimento atendimento) throws SQLException {
        String sql = "INSERT INTO tabela_atendimento (cdAtendimento, cdDescricao, qtDias, dsHabito, dsTempoSono, " +
                     "dsHereditaria, dtEnvio, fgTipo, cdPaciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setAtendimentoParameters(statement, atendimento);
            statement.executeUpdate();
        }
    }

    public Optional<Atendimento> find(String cdAtendimento) throws SQLException {
        String sql = "SELECT * FROM tabela_atendimento WHERE cdAtendimento = ?";
        Atendimento atendimento = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdAtendimento);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    atendimento = mapResultSetToAtendimento(rs);
                }
            }
        }
        return Optional.ofNullable(atendimento);
    }

    public void update(String cdAtendimento, Atendimento atendimento) {
        String sql = "UPDATE tabela_atendimento SET cdDescricao=?, qtDias=?, dsHabito=?, dsTempoSono=?, " +
                     "dsHereditaria=?, dtEnvio=?, fgTipo=?, cdPaciente=? WHERE cdAtendimento=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setAtendimentoParameters(statement, atendimento);
            statement.setString(9, cdAtendimento);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdAtendimento) {
        String sql = "DELETE FROM tabela_atendimento WHERE cdAtendimento = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdAtendimento);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Atendimento mapResultSetToAtendimento(ResultSet resultSet) throws SQLException {
        Atendimento atendimento = new Atendimento();
        atendimento.setCdAtendimento(resultSet.getString("cdAtendimento"));
        atendimento.setCdDescricao(resultSet.getString("cdDescricao"));
        atendimento.setQtDias(resultSet.getString("qtDias"));
        atendimento.setDsHabito(resultSet.getString("dsHabito"));
        atendimento.setDsTempoSono(resultSet.getString("dsTempoSono"));
        atendimento.setDsHereditaria(resultSet.getString("dsHereditaria"));
        atendimento.setDtEnvio(resultSet.getInt("dtEnvio"));
        atendimento.setFgTipo(resultSet.getString("fgTipo"));
        atendimento.setCdPaciente(resultSet.getString("cdPaciente"));
        return atendimento;
    }

    private void setAtendimentoParameters(PreparedStatement preparedStatement, Atendimento atendimento) throws SQLException {
        preparedStatement.setString(1, atendimento.getCdAtendimento());
        preparedStatement.setString(2, atendimento.getCdDescricao());
        preparedStatement.setString(3, atendimento.getQtDias());
        preparedStatement.setString(4, atendimento.getDsHabito());
        preparedStatement.setString(5, atendimento.getDsTempoSono());
        preparedStatement.setString(6, atendimento.getDsHereditaria());
        preparedStatement.setInt(7, atendimento.getDtEnvio());
        preparedStatement.setString(8, atendimento.getFgTipo());
        preparedStatement.setString(9, atendimento.getCdPaciente());
    }

    public static class ContatoRepository {

        public List<Contato> findAll() throws SQLException {
            List<Contato> contatos = new ArrayList<>();
            String sql = "SELECT * FROM tabela_contato";  // Substitua "tabela_contato" pelo nome correto da sua tabela

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    contatos.add(mapResultSetToContato(results));
                }
            }
            return contatos;
        }

        public void add(Contato contato) throws SQLException {
            String sql = "INSERT INTO tabela_contato (cdContato, nmContato, nrDDI, nrDDD, nrTelefone, dtCadastro, cdUsuario, cdTipoContato) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                setContatoParameters(statement, contato);
                statement.executeUpdate();
            }
        }

        public Optional<Contato> find(String cdContato) throws SQLException {
            String sql = "SELECT * FROM tabela_contato WHERE cdContato = ?";
            Contato contato = null;

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, cdContato);

                try (ResultSet rs = statement.executeQuery()) {
                    if (rs.next()) {
                        contato = mapResultSetToContato(rs);
                    }
                }
            }
            return Optional.ofNullable(contato);
        }

        public void update(String cdContato, Contato contato) {
            String sql = "UPDATE tabela_contato SET nmContato=?, nrDDI=?, nrDDD=?, nrTelefone=?, dtCadastro=?, cdUsuario=?, cdTipoContato=? WHERE cdContato=?";
            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                setContatoParameters(statement, contato);
                statement.setString(8, cdContato);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void delete(String cdContato) {
            String sql = "DELETE FROM tabela_contato WHERE cdContato = ?";

            try (Connection conn = DatabaseFactory.getConnection();
                 PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, cdContato);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private Contato mapResultSetToContato(ResultSet resultSet) throws SQLException {
            Contato contato = new Contato();
            contato.setCdContato(resultSet.getString("cdContato"));
            contato.setNmContato(resultSet.getString("nmContato"));
            contato.setNrDDI(resultSet.getString("nrDDI"));
            contato.setNrDDD(resultSet.getString("nrDDD"));
            contato.setNrTelefone(resultSet.getString("nrTelefone"));
            contato.setDtCadastro(resultSet.getInt("dtCadastro"));
            contato.setCdUsuario(resultSet.getString("cdUsuario"));
            contato.setCdTipoContato(resultSet.getString("cdTipoContato"));
            return contato;
        }

        private void setContatoParameters(PreparedStatement preparedStatement, Contato contato) throws SQLException {
            preparedStatement.setString(1, contato.getCdContato());
            preparedStatement.setString(2, contato.getNmContato());
            preparedStatement.setString(3, contato.getNrDDI());
            preparedStatement.setString(4, contato.getNrDDD());
            preparedStatement.setString(5, contato.getNrTelefone());
            preparedStatement.setInt(6, contato.getDtCadastro());
            preparedStatement.setString(7, contato.getCdUsuario());
            preparedStatement.setString(8, contato.getCdTipoContato());
        }
    }
}
