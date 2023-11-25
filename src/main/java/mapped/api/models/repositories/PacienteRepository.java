package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacienteRepository {

    public List<Paciente> findAll() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_paciente";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                pacientes.add(mapResultSetToPaciente(results));
            }
        }
        return pacientes;
    }

    public void add(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO t_gs_paciente (cdPaciente, nmPaciente, nrPeso, nrAltura, nmGrupoSanguineo, flSexoBiologico) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPacienteParameters(statement, paciente);
            statement.executeUpdate();
        }
    }

    public Optional<Paciente> find(int cdPaciente) throws SQLException {
        String sql = "SELECT * FROM t_gs_paciente WHERE cdPaciente = ?";
        Paciente paciente = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cdPaciente);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    paciente = mapResultSetToPaciente(rs);
                }
            }
        }
        return Optional.ofNullable(paciente);
    }

    public void update(int cdPaciente, Paciente paciente) {
        String sql = "UPDATE t_gs_paciente SET nmPaciente=?, nrPeso=?, nrAltura=?, nmGrupoSanguineo=?, flSexoBiologico=? WHERE cdPaciente=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPacienteParameters(statement, paciente);
            statement.setInt(6, cdPaciente);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int cdPaciente) {
        String sql = "DELETE FROM t_gs_paciente WHERE cdPaciente = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cdPaciente);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Paciente mapResultSetToPaciente(ResultSet resultSet) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setCdPaciente(resultSet.getInt("cdPaciente"));
        paciente.setNmPaciente(resultSet.getString("nmPaciente"));
        paciente.setNrPeso(resultSet.getInt("nrPeso"));
        paciente.setNrAltura(resultSet.getInt("nrAltura"));
        paciente.setNmGrupoSanguineo(resultSet.getString("nmGrupoSanguineo"));
        paciente.setFlSexoBiologico(resultSet.getString("flSexoBiologico"));
        return paciente;
    }

    private void setPacienteParameters(PreparedStatement preparedStatement, Paciente paciente) throws SQLException {
        preparedStatement.setInt(1, paciente.getCdPaciente());
        preparedStatement.setString(2, paciente.getNmPaciente());
        preparedStatement.setInt(3, paciente.getNrPeso());
        preparedStatement.setInt(4, paciente.getNrAltura());
        preparedStatement.setString(5, paciente.getNmGrupoSanguineo());
        preparedStatement.setString(6, paciente.getFlSexoBiologico());
    }
}
