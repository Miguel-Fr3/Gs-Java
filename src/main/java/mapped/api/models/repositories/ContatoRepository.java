package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContatoRepository {

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
