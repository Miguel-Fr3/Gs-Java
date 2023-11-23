package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.PlanoSaude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlanoSaudeRepository {

    public List<PlanoSaude> findAll() throws SQLException {
        List<PlanoSaude> planosSaude = new ArrayList<>();
        String sql = "SELECT * FROM tabela_plano_saude";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                planosSaude.add(mapResultSetToPlanoSaude(results));
            }
        }
        return planosSaude;
    }

    public void add(PlanoSaude planoSaude) throws SQLException {
        String sql = "INSERT INTO tabela_plano_saude (cdPlanoSaude, dsRazaoSocial, nmFantasia, dsPlanoSaude, nrCnpj, nmContato, nrTelefone, dtCadastro, fgAtivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPlanoSaudeParameters(statement, planoSaude);
            statement.executeUpdate();
        }
    }

    public Optional<PlanoSaude> find(String cdPlanoSaude) throws SQLException {
        String sql = "SELECT * FROM tabela_plano_saude WHERE cdPlanoSaude = ?";
        PlanoSaude planoSaude = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdPlanoSaude);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    planoSaude = mapResultSetToPlanoSaude(rs);
                }
            }
        }
        return Optional.ofNullable(planoSaude);
    }

    public void update(String cdPlanoSaude, PlanoSaude planoSaude) {
        String sql = "UPDATE tabela_plano_saude SET dsRazaoSocial=?, nmFantasia=?, dsPlanoSaude=?, nrCnpj=?, nmContato=?, nrTelefone=?, dtCadastro=?, fgAtivo=? WHERE cdPlanoSaude=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPlanoSaudeParameters(statement, planoSaude);
            statement.setString(9, cdPlanoSaude);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdPlanoSaude) {
        String sql = "DELETE FROM tabela_plano_saude WHERE cdPlanoSaude = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdPlanoSaude);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PlanoSaude mapResultSetToPlanoSaude(ResultSet resultSet) throws SQLException {
        PlanoSaude planoSaude = new PlanoSaude();
        planoSaude.setCdPlanoSaude(resultSet.getString("cdPlanoSaude"));
        planoSaude.setDsRazaoSocial(resultSet.getString("dsRazaoSocial"));
        planoSaude.setNmFantasia(resultSet.getString("nmFantasia"));
        planoSaude.setDsPlanoSaude(resultSet.getString("dsPlanoSaude"));
        planoSaude.setNrCnpj(resultSet.getString("nrCnpj"));
        planoSaude.setNmContato(resultSet.getString("nmContato"));
        planoSaude.setNrTelefone(resultSet.getString("nrTelefone"));
        planoSaude.setDtCadastro(resultSet.getInt("dtCadastro"));
        planoSaude.setFgAtivo(resultSet.getInt("fgAtivo"));
        return planoSaude;
    }

    private void setPlanoSaudeParameters(PreparedStatement preparedStatement, PlanoSaude planoSaude) throws SQLException {
        preparedStatement.setString(1, planoSaude.getCdPlanoSaude());
        preparedStatement.setString(2, planoSaude.getDsRazaoSocial());
        preparedStatement.setString(3, planoSaude.getNmFantasia());
        preparedStatement.setString(4, planoSaude.getDsPlanoSaude());
        preparedStatement.setString(5, planoSaude.getNrCnpj());
        preparedStatement.setString(6, planoSaude.getNmContato());
        preparedStatement.setString(7, planoSaude.getNrTelefone());
        preparedStatement.setInt(8, planoSaude.getDtCadastro());
        preparedStatement.setInt(9, planoSaude.getFgAtivo());
    }
}
