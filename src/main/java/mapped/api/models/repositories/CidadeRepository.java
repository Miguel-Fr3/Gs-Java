package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CidadeRepository {

    public List<Cidade> findAll() throws SQLException {
        List<Cidade> cidades = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_cidade";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                cidades.add(mapResultSetToCidade(results));
            }
        }
        return cidades;
    }

    public void add(Cidade cidade) throws SQLException {
        String sql = "INSERT INTO t_gs_cidade (cdCidade, nmCidade, cdEstado) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCidadeParameters(statement, cidade);
            statement.executeUpdate();
        }
    }

    public Optional<Cidade> find(String cdCidade) throws SQLException {
        String sql = "SELECT * FROM t_gs_cidade WHERE cdCidade = ?";
        Cidade cidade = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdCidade);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    cidade = mapResultSetToCidade(rs);
                }
            }
        }
        return Optional.ofNullable(cidade);
    }

    public void update(String cdCidade, Cidade cidade) {
        String sql = "UPDATE t_gs_cidade SET nmCidade=?, cdEstado=? WHERE cdCidade=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setCidadeParameters(statement, cidade);
            statement.setString(3, cdCidade);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdCidade) {
        String sql = "DELETE FROM t_gs_cidade WHERE cdCidade = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdCidade);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Cidade mapResultSetToCidade(ResultSet resultSet) throws SQLException {
        Cidade cidade = new Cidade();
        cidade.setCdCidade(resultSet.getInt("cdCidade"));
        cidade.setNmCidade(resultSet.getString("nmCidade"));
        cidade.setCdEstado(resultSet.getInt("cdEstado"));
        return cidade;
    }

    private void setCidadeParameters(PreparedStatement preparedStatement, Cidade cidade) throws SQLException {
        preparedStatement.setInt(1, cidade.getCdCidade());
        preparedStatement.setString(2, cidade.getNmCidade());
        preparedStatement.setInt(3, cidade.getCdEstado());
    }
}
