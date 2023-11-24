package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Contato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContatoRepository {

    public List<Contato> findAll() throws SQLException {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_contato";

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
        String sql = "INSERT INTO t_gs_contato (cdContato, nmContato, nrDDI, nrDDD, nrTelefone, dtCadastro, cdUsuario, cdTipoContato) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setContatoParameters(statement, contato);
            statement.executeUpdate();
        }
    }

    public Optional<Contato> find(String cdContato) throws SQLException {
        String sql = "SELECT * FROM t_gs_contato WHERE cdContato = ?";
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
        String sql = "UPDATE t_gs_contato SET nmContato=?, nrDDI=?, nrDDD=?, nrTelefone=?, dtCadastro=?, cdUsuario=?, cdTipoContato=? WHERE cdContato=?";
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
        String sql = "DELETE FROM t_gs_contato WHERE cdContato = ?";

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
        contato.setCdContato(resultSet.getInt("cdContato"));
        contato.setNmContato(resultSet.getString("nmContato"));
        contato.setNrDDI(resultSet.getInt("nrDDI"));
        contato.setNrDDD(resultSet.getInt("nrDDD"));
        contato.setNrTelefone(resultSet.getInt("nrTelefone"));
        contato.setDtCadastro(resultSet.getDate("dtCadastro"));
        contato.setCdUsuario(resultSet.getInt("cdUsuario"));
        contato.setCdTipoContato(resultSet.getInt("cdTipoContato"));
        return contato;
    }

    private void setContatoParameters(PreparedStatement preparedStatement, Contato contato) throws SQLException {
        preparedStatement.setInt(1, contato.getCdContato());
        preparedStatement.setString(2, contato.getNmContato());
        preparedStatement.setInt(3, contato.getNrDDI());
        preparedStatement.setInt(4, contato.getNrDDD());
        preparedStatement.setInt(5, contato.getNrTelefone());
        preparedStatement.setDate(6, (Date) contato.getDtCadastro());
        preparedStatement.setInt(7, contato.getCdUsuario());
        preparedStatement.setInt(8, contato.getCdTipoContato());
    }
}
