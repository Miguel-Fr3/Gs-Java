package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository {

    public List<Usuario> findAll() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_usuario";

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
        String sql = "INSERT INTO t_gs_usuario (cdUsuario, nmUsuario, dtNascimento, dtCadastro, nrRG, dsEscolaridade, dsEstadoCivil, dsNacionalidade, dsProfissao, fgAtivo, cdEndereco, cdLogin, cdPaciente) VALUES (?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setUsuarioParameters(statement, usuario);
            statement.executeUpdate();
        }
    }

    public Optional<Usuario> find(Integer cdUsuario) throws SQLException {
        String sql = "SELECT * FROM t_gs_usuario WHERE cdUsuario = ?";
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
        String sql = "UPDATE t_gs_usuario SET nmUsuario=?, dtNascimento=?, dtCadastro=?, nrRG=?, dsEscolaridade=?, dsEstadoCivil=?, dsNacionalidade=?, dsProfissao=?, fgAtivo=?, cdEndereco=?, cdLogin=?, cdPaciente=? WHERE cdUsuario=?";
        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            setUsuarioParameters(statement, usuario);
            statement.setInt(13, cdUsuario);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer cdUsuario) {
        String sql = "DELETE FROM t_gs_usuario WHERE cdUsuario = ?";

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
        usuario.setDtNascimento(resultSet.getDate("dtNascimento"));
        usuario.setDtCadastro(resultSet.getDate("dtCadastro"));
        usuario.setNrRG(Integer.valueOf(resultSet.getString("nrRG")));
        usuario.setDsEscolaridade(resultSet.getString("dsEscolaridade"));
        usuario.setDsEstadoCivil(resultSet.getString("dsEstadoCivil"));
        usuario.setDsNacionalidade(resultSet.getString("dsNacionalidade"));
        usuario.setDsProfissao(resultSet.getString("dsProfissao"));
        usuario.setFgAtivo(resultSet.getInt("fgAtivo"));
        usuario.setCdEndereco(Integer.valueOf(resultSet.getString("cdEndereco")));
        usuario.setCdLogin(Integer.valueOf(resultSet.getString("cdLogin")));
        usuario.setCdPaciente(Integer.valueOf(resultSet.getString("cdPaciente")));
        return usuario;
    }

    private void setUsuarioParameters(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        preparedStatement.setInt(1, usuario.getCdUsuario());
        preparedStatement.setString(2, usuario.getNmUsuario());
        preparedStatement.setDate(3, (Date) usuario.getDtNascimento());
        preparedStatement.setDate(4, (Date) usuario.getDtCadastro());
        preparedStatement.setInt(5, usuario.getNrRG());
        preparedStatement.setString(6, usuario.getDsEscolaridade());
        preparedStatement.setString(7, usuario.getDsEstadoCivil());
        preparedStatement.setString(8, usuario.getDsNacionalidade());
        preparedStatement.setString(9, usuario.getDsProfissao());
        preparedStatement.setInt(10, usuario.getFgAtivo());
        preparedStatement.setInt(11, usuario.getCdEndereco());
        preparedStatement.setInt(12, usuario.getCdLogin());
        preparedStatement.setInt(13, usuario.getCdPaciente());
    }
}
