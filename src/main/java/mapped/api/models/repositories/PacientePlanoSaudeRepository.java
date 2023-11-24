package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.PacientePlanoSaude;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacientePlanoSaudeRepository {

    public List<PacientePlanoSaude> findAll() throws SQLException {
        List<PacientePlanoSaude> pacientesPlanosSaude = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_paciente_plano_saude";
        
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                pacientesPlanosSaude.add(mapResultSetToPacientePlanoSaude(results));
            }
        }
        return pacientesPlanosSaude;
    }

    public void add(PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        String sql = "INSERT INTO t_gs_paciente_plano_saude (cdPlanoPaciente, nrCarteira, dtInicio, dtFim, cdPaciente, cdPlanoSaude) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPacientePlanoSaudeParameters(statement, pacientePlanoSaude);
            statement.executeUpdate();
        }
    }

    public Optional<PacientePlanoSaude> find(String cdPlanoPaciente) throws SQLException {
        String sql = "SELECT * FROM t_gs_paciente_plano_saude WHERE cdPlanoPaciente = ?";
        PacientePlanoSaude pacientePlanoSaude = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdPlanoPaciente);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    pacientePlanoSaude = mapResultSetToPacientePlanoSaude(rs);
                }
            }
        }
        return Optional.ofNullable(pacientePlanoSaude);
    }

    public void update(String cdPlanoPaciente, PacientePlanoSaude pacientePlanoSaude) {
        String sql = "UPDATE t_gs_paciente_plano_saude SET nrCarteira=?, dtInicio=?, dtFim=?, cdPaciente=?, cdPlanoSaude=? WHERE cdPlanoPaciente=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPacientePlanoSaudeParameters(statement, pacientePlanoSaude);
            statement.setString(6, cdPlanoPaciente);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String cdPlanoPaciente) {
        String sql = "DELETE FROM t_gs_paciente_plano_saude WHERE cdPlanoPaciente = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdPlanoPaciente);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private PacientePlanoSaude mapResultSetToPacientePlanoSaude(ResultSet resultSet) throws SQLException {
        PacientePlanoSaude pacientePlanoSaude = new PacientePlanoSaude();
        pacientePlanoSaude.setCdPlanoPaciente(resultSet.getInt("cdPlanoPaciente"));
        pacientePlanoSaude.setNrCarteira(resultSet.getInt("nrCarteira"));
        pacientePlanoSaude.setDtInicio(resultSet.getDate("dtInicio"));
        pacientePlanoSaude.setDtFim(resultSet.getDate("dtFim"));
        pacientePlanoSaude.setCdPaciente(resultSet.getInt("cdPaciente"));
        pacientePlanoSaude.setCdPlanoSaude(resultSet.getInt("cdPlanoSaude"));
        return pacientePlanoSaude;
    }

    private void setPacientePlanoSaudeParameters(PreparedStatement preparedStatement, PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        preparedStatement.setInt(1, pacientePlanoSaude.getCdPlanoPaciente());
        preparedStatement.setInt(2, pacientePlanoSaude.getNrCarteira());
        preparedStatement.setDate(3, (Date) pacientePlanoSaude.getDtInicio());
        preparedStatement.setDate(4, (Date) pacientePlanoSaude.getDtFim());
        preparedStatement.setInt(5, pacientePlanoSaude.getCdPaciente());
        preparedStatement.setInt(6, pacientePlanoSaude.getCdPlanoSaude());
    }
}
