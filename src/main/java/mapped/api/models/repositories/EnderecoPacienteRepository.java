package mapped.api.models.repositories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.EnderecoPaciente;

public class EnderecoPacienteRepository {

    public List<EnderecoPaciente> findAll() throws SQLException {
        List<EnderecoPaciente> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_endereco_paciente";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                enderecos.add(mapResultSetToEnderecoPaciente(results));
            }
        }
        return enderecos;
    }

    public void add(EnderecoPaciente endereco) throws SQLException {
        String sql = "INSERT INTO t_gs_endereco_paciente (cdEndereco, nrLogradouro, dsComplemento, dsPontoReferencia, cdLogradouro) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setEnderecoPacienteParameters(statement, endereco);
            statement.executeUpdate();
        }
    }

    public Optional<EnderecoPaciente> find(String cdEndereco) throws SQLException {
        String sql = "SELECT * FROM t_gs_endereco_paciente WHERE cdEndereco = ?";
        EnderecoPaciente endereco = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdEndereco);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    endereco = mapResultSetToEnderecoPaciente(rs);
                }
            }
        }
        return Optional.ofNullable(endereco);
    }

    public void update(String cdEndereco, EnderecoPaciente endereco) {
        String sql = "UPDATE t_gs_endereco_paciente SET nrLogradouro=?, dsComplemento=?, dsPontoReferencia=?, cdLogradouro=? WHERE cdEndereco=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setEnderecoPacienteParameters(statement, endereco);
            statement.setString(5, cdEndereco);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdEndereco) {
        String sql = "DELETE FROM t_gs_endereco_paciente WHERE cdEndereco = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdEndereco);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private EnderecoPaciente mapResultSetToEnderecoPaciente(ResultSet resultSet) throws SQLException {
        EnderecoPaciente endereco = new EnderecoPaciente();
        endereco.setCdEndereco(resultSet.getInt("cdEndereco"));
        endereco.setNrLogradouro(resultSet.getInt("nrLogradouro"));
        endereco.setDsComplemento(resultSet.getString("dsComplemento"));
        endereco.setDsPontoReferencia(resultSet.getString("dsPontoReferencia"));
        endereco.setCdLogradouro(resultSet.getInt("cdLogradouro"));
        return endereco;
    }

    private void setEnderecoPacienteParameters(PreparedStatement preparedStatement, EnderecoPaciente endereco) throws SQLException {
        preparedStatement.setInt(1, endereco.getCdEndereco());
        preparedStatement.setInt(2, endereco.getNrLogradouro());
        preparedStatement.setString(3, endereco.getDsComplemento());
        preparedStatement.setString(4, endereco.getDsPontoReferencia());
        preparedStatement.setInt(5, endereco.getCdLogradouro());
    }
}
