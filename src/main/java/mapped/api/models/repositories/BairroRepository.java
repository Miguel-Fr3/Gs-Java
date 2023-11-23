package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Bairro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BairroRepository {

    public List<Bairro> findAll() throws SQLException {
        List<Bairro> bairros = new ArrayList<>();
        String sql = "SELECT * FROM tabela_bairro";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                bairros.add(mapResultSetToBairro(results));
            }
        }
        return bairros;
    }

    public void add(Bairro bairro) throws SQLException {
        String sql = "INSERT INTO tabela_bairro (cdBairro, nmBairro, nmZonaBairro, cdCidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setBairroParameters(statement, bairro);
            statement.executeUpdate();
        }
    }

    public Optional<Bairro> find(int cdBairro) throws SQLException {
        String sql = "SELECT * FROM tabela_bairro WHERE cdBairro = ?";
        Bairro bairro = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cdBairro);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    bairro = mapResultSetToBairro(rs);
                }
            }
        }
        return Optional.ofNullable(bairro);
    }

    public void update(int cdBairro, Bairro bairro) {
        String sql = "UPDATE tabela_bairro SET nmBairro=?, nmZonaBairro=?, cdCidade=? WHERE cdBairro=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setBairroParameters(statement, bairro);
            statement.setInt(4, cdBairro);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int cdBairro) {
        String sql = "DELETE FROM tabela_bairro WHERE cdBairro = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cdBairro);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Bairro mapResultSetToBairro(ResultSet resultSet) throws SQLException {
        Bairro bairro = new Bairro();
        bairro.setCdBairro(resultSet.getInt("cdBairro"));
        bairro.setNmBairro(resultSet.getString("nmBairro"));
        bairro.setNmZonaBairro(resultSet.getString("nmZonaBairro"));
        bairro.setCdCidade(resultSet.getString("cdCidade"));
        return bairro;
    }

    private void setBairroParameters(PreparedStatement preparedStatement, Bairro bairro) throws SQLException {
        preparedStatement.setInt(1, bairro.getCdBairro());
        preparedStatement.setString(2, bairro.getNmBairro());
        preparedStatement.setString(3, bairro.getNmZonaBairro());
        preparedStatement.setString(4, bairro.getCdCidade());
    }
}
