package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.PacientePlanoSaude;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PacientePlanoSaudeRepository {

    public List<PacientePlanoSaude> findAll() throws SQLException {
        List<PacientePlanoSaude> pacientesPlanosSaude = new ArrayList<>();
        String sql = "SELECT * FROM tabela_paciente_plano_saude";  
        
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
        String sql = "INSERT INTO tabela_paciente_plano_saude (cdPlanoPaciente, nrCarteira, dtInicio, dtFim, cdPaciente, cdPlanoSaude) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setPacientePlanoSaudeParameters(statement, pacientePlanoSaude);
            statement.executeUpdate();
        }
    }

    public Optional<PacientePlanoSaude> find(String cdPlanoPaciente) throws SQLException {
        String sql = "SELECT * FROM tabela_paciente_plano_saude WHERE cdPlanoPaciente = ?";
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
        String sql = "UPDATE tabela_paciente_plano_saude SET nrCarteira=?, dtInicio=?, dtFim=?, cdPaciente=?, cdPlanoSaude=? WHERE cdPlanoPaciente=?";
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
        String sql = "DELETE FROM tabela_paciente_plano_saude WHERE cdPlanoPaciente = ?";

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
        pacientePlanoSaude.setCdPlanoPaciente(resultSet.getString("cdPlanoPaciente"));
        pacientePlanoSaude.setNrCarteira(resultSet.getString("nrCarteira"));
        pacientePlanoSaude.setDtInicio(resultSet.getInt("dtInicio"));
        pacientePlanoSaude.setDtFim(resultSet.getInt("dtFim"));
        pacientePlanoSaude.setCdPaciente(resultSet.getString("cdPaciente"));
        pacientePlanoSaude.setCdPlanoSaude(resultSet.getString("cdPlanoSaude"));
        return pacientePlanoSaude;
    }

    private void setPacientePlanoSaudeParameters(PreparedStatement preparedStatement, PacientePlanoSaude pacientePlanoSaude) throws SQLException {
        preparedStatement.setString(1, pacientePlanoSaude.getCdPlanoPaciente());
        preparedStatement.setString(2, pacientePlanoSaude.getNrCarteira());
        preparedStatement.setInt(3, pacientePlanoSaude.getDtInicio());
        preparedStatement.setInt(4, pacientePlanoSaude.getDtFim());
        preparedStatement.setString(5, pacientePlanoSaude.getCdPaciente());
        preparedStatement.setString(6, pacientePlanoSaude.getCdPlanoSaude());
    }
}
