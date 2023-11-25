package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Atendimento;
import mapped.api.models.entities.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AtendimentoRepository {

    public List<Atendimento> findAll() throws SQLException {
        List<Atendimento> atendimentos = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_atendimento";

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
        String sql = "INSERT INTO t_gs_atendimento (cdAtendimento, cdDescricao, qtDias, dsHabito, dsTempoSono, " +
                     "dsHereditaria, dtEnvio, fgTipo, cdPaciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setAtendimentoParameters(statement, atendimento);
            statement.executeUpdate();
        }
    }

    public Optional<Atendimento> find(String cdAtendimento) throws SQLException {
        String sql = "SELECT * FROM t_gs_atendimento WHERE cdAtendimento = ?";
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
        String sql = "UPDATE t_gs_atendimento SET cdDescricao=?, qtDias=?, dsHabito=?, dsTempoSono=?, " +
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
        String sql = "DELETE FROM t_gs_atendimento WHERE cdAtendimento = ?";

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
        atendimento.setCdAtendimento(resultSet.getInt("cdAtendimento"));
        atendimento.setCdDescricao(resultSet.getInt("cdDescricao"));
        atendimento.setQtDias(resultSet.getInt("qtDias"));
        atendimento.setDsHabito(resultSet.getString("dsHabito"));
        atendimento.setDsTempoSono(resultSet.getString("dsTempoSono"));
        atendimento.setDsHereditaria(resultSet.getString("dsHereditaria"));
        atendimento.setDtEnvio(resultSet.getDate("dtEnvio"));
        atendimento.setFgTipo(resultSet.getInt("fgTipo"));
        atendimento.setCdPaciente(resultSet.getInt("cdPaciente"));
        return atendimento;
    }

    private void setAtendimentoParameters(PreparedStatement preparedStatement, Atendimento atendimento) throws SQLException {
        preparedStatement.setInt(1, atendimento.getCdAtendimento());
        preparedStatement.setInt(2, atendimento.getCdDescricao());
        preparedStatement.setInt(3, atendimento.getQtDias());
        preparedStatement.setString(4, atendimento.getDsHabito());
        preparedStatement.setString(5, atendimento.getDsTempoSono());
        preparedStatement.setString(6, atendimento.getDsHereditaria());
        preparedStatement.setDate(7, (Date) atendimento.getDtEnvio());
        preparedStatement.setInt(8, atendimento.getFgTipo());
        preparedStatement.setInt(9, atendimento.getCdPaciente());
    }

}
