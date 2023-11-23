package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {

    public List<Usuario> findAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM tabela_usuario";  

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                usuarios.add(mapResultSetToUsuario(results));
            }
        }
        return usuarios;
    }

    public void add(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO tabela_usuario (cdUsuario, nmUsuario, dtNascimento, dtCadastro, nrRG, rua, dsEscolaridade, dsEstadoCivil, dsNacionalidade, dsProfissao, fgAtivo, cdEndereco, cdLogin, cdPaciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setUsuarioParameters(statement, usuario);
            statement.executeUpdate();
        }
    }

    public Optional<Usuario> find(Integer cdUsuario) throws SQLException {
        String sql = "SELECT * FROM tabela_usuario WHERE cdUsuario = ?";
        Usuario usuario = null;

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cdUsuario);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    usuario = mapResultSetToUsuario(rs);
                }
            }
        }
        return Optional.ofNullable(usuario);
    }

    public void update(Integer cdUsuario, Usuario usuario) {
        String sql = "UPDATE tabela_usuario SET nmUsuario=?, dtNascimento=?, dtCadastro=?, nrRG=?, rua=?, dsEscolaridade=?, dsEstadoCivil=?, dsNacionalidade=?, dsProfissao=?, fgAtivo=?, cdEndereco=?, cdLogin=?, cdPaciente=? WHERE cdUsuario=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setUsuarioParameters(statement, usuario);
            statement.setInt(14, cdUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer cdUsuario) {
        String sql = "DELETE FROM tabela_usuario WHERE cdUsuario = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, cdUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Usuario mapResultSetToUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setCdUsuario(resultSet.getInt("cdUsuario"));
        usuario.setNmUsuario(resultSet.getString("nmUsuario"));
        usuario.setDtNascimento(resultSet.getInt("dtNascimento"));
        usuario.setDtCadastro(resultSet.getInt("dtCadastro"));
        usuario.setNrRG(resultSet.getString("nrRG"));
        usuario.setRua(resultSet.getString("rua"));
        usuario.setDsEscolaridade(resultSet.getString("dsEscolaridade"));
        usuario.setDsEstadoCivil(resultSet.getString("dsEstadoCivil"));
        usuario.setDsNacionalidade(resultSet.getString("dsNacionalidade"));
        usuario.setDsProfissao(resultSet.getString("dsProfissao"));
        usuario.setFgAtivo(resultSet.getInt("fgAtivo"));
        usuario.setCdEndereco(resultSet.getString("cdEndereco"));
        usuario.setCdLogin(resultSet.getString("cdLogin"));
        usuario.setCdPaciente(resultSet.getString("cdPaciente"));
        return usuario;
    }

    private void setUsuarioParameters(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        preparedStatement.setInt(1, usuario.getCdUsuario());
        preparedStatement.setString(2, usuario.getNmUsuario());
        preparedStatement.setInt(3, usuario.getDtNascimento());
        preparedStatement.setInt(4, usuario.getDtCadastro());
        preparedStatement.setString(5, usuario.getNrRG());
        preparedStatement.setString(6, usuario.getRua());
        preparedStatement.setString(7, usuario.getDsEscolaridade());
        preparedStatement.setString(8, usuario.getDsEstadoCivil());
        preparedStatement.setString(9, usuario.getDsNacionalidade());
        preparedStatement.setString(10, usuario.getDsProfissao());
        preparedStatement.setInt(11, usuario.getFgAtivo());
        preparedStatement.setString(12, usuario.getCdEndereco());
        preparedStatement.setString(13, usuario.getCdLogin());
        preparedStatement.setString(14, usuario.getCdPaciente());
    }
}
