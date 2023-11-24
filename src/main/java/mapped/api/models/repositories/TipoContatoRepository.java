package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.TipoContato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TipoContatoRepository {

    public List<TipoContato> findAll() throws SQLException {
        List<TipoContato> tiposContato = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_tipo_contato";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                tiposContato.add(mapResultSetToTipoContato(results));
            }
        }
        return tiposContato;
    }

    public void add(TipoContato tipoContato) throws SQLException {
        String sql = "INSERT INTO t_gs_tipo_contato (cdTipoContato, nmTipoContato, dtInicio, dtFim) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setTipoContatoParameters(statement, tipoContato);
            statement.executeUpdate();
        }
    }

    public Optional<TipoContato> find(String cdTipoContato) throws SQLException {
        String sql = "SELECT * FROM t_gs_tipo_contato WHERE cdTipoContato = ?";
        TipoContato tipoContato = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdTipoContato);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    tipoContato = mapResultSetToTipoContato(rs);
                }
            }
        }
        return Optional.ofNullable(tipoContato);
    }

    public void update(String cdTipoContato, TipoContato tipoContato) {
        String sql = "UPDATE t_gs_tipo_contato SET nmTipoContato=?, dtInicio=?, dtFim=? WHERE cdTipoContato=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setTipoContatoParameters(statement, tipoContato);
            statement.setString(4, cdTipoContato);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdTipoContato) {
        String sql = "DELETE FROM t_gs_tipo_contato WHERE cdTipoContato = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdTipoContato);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private TipoContato mapResultSetToTipoContato(ResultSet resultSet) throws SQLException {
        TipoContato tipoContato = new TipoContato();
        tipoContato.setCdTipoContato(resultSet.getInt("cdTipoContato"));
        tipoContato.setNmTipoContato(resultSet.getString("nmTipoContato"));
        tipoContato.setDtInicio(resultSet.getDate("dtInicio"));
        tipoContato.setDtFim(resultSet.getDate("dtFim"));
        return tipoContato;
    }

    private void setTipoContatoParameters(PreparedStatement preparedStatement, TipoContato tipoContato) throws SQLException {
        preparedStatement.setInt(1, tipoContato.getCdTipoContato());
        preparedStatement.setString(2, tipoContato.getNmTipoContato());
        preparedStatement.setDate(3, (Date) tipoContato.getDtInicio());
        preparedStatement.setDate(4, (Date) tipoContato.getDtFim());
    }
}
