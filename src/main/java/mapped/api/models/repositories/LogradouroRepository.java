package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Logradouro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogradouroRepository {

    public List<Logradouro> findAll() throws SQLException {
        List<Logradouro> logradouros = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_logradouro";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                logradouros.add(mapResultSetToLogradouro(results));
            }
        }
        return logradouros;
    }

    public void add(Logradouro logradouro) throws SQLException {
        String sql = "INSERT INTO t_gs_logradouro (cdLogradouro, nmRua, nrCep, cdBairro) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setLogradouroParameters(statement, logradouro);
            statement.executeUpdate();
        }
    }

    public Optional<Logradouro> find(String cdLogradouro) throws SQLException {
        String sql = "SELECT * FROM t_gs_logradouro WHERE cdLogradouro = ?";
        Logradouro logradouro = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdLogradouro);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    logradouro = mapResultSetToLogradouro(rs);
                }
            }
        }
        return Optional.ofNullable(logradouro);
    }

    public void update(String cdLogradouro, Logradouro logradouro) {
        String sql = "UPDATE t_gs_logradouro SET nmRua=?, nrCep=?, cdBairro=? WHERE cdLogradouro=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setLogradouroParameters(statement, logradouro);
            statement.setString(4, cdLogradouro);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdLogradouro) {
        String sql = "DELETE FROM t_gs_logradouro WHERE cdLogradouro = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdLogradouro);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Logradouro mapResultSetToLogradouro(ResultSet resultSet) throws SQLException {
        Logradouro logradouro = new Logradouro();
        logradouro.setCdLogradouro(resultSet.getInt("cdLogradouro"));
        logradouro.setNmRua(resultSet.getString("nmRua"));
        logradouro.setNrCep(resultSet.getInt("nrCep"));
        logradouro.setCdBairro(resultSet.getInt("cdBairro"));
        return logradouro;
    }

    private void setLogradouroParameters(PreparedStatement preparedStatement, Logradouro logradouro) throws SQLException {
        preparedStatement.setInt(1, logradouro.getCdLogradouro());
        preparedStatement.setString(2, logradouro.getNmRua());
        preparedStatement.setInt(3, logradouro.getNrCep());
        preparedStatement.setInt(4, logradouro.getCdBairro());
    }
}
