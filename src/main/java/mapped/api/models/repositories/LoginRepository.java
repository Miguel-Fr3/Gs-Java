package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginRepository {

    public List<Login> findAll() throws SQLException {
        List<Login> logins = new ArrayList<>();
        String sql = "SELECT * FROM t_gs_login";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet results = statement.executeQuery()) {
            while (results.next()) {
                logins.add(new Login(
                        results.getInt("cdLogin"),
                        results.getString("dsEmail"),
                        results.getString("dsSenha"),
                        results.getInt("fgAtivo")));
            }
        }
        return logins;
    }

    public void add(Login login) {
        String sql = "INSERT INTO t_gs_login (cdLogin, dsEmail, dsSenha, fgAtivo) VALUES (?,?,?,?)";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, login.getCdLogin());
            statement.setString(2, login.getDsEmail());
            statement.setString(3, login.getDsSenha());


            if (login.getFgAtivo() != null) {
                statement.setInt(4, login.getFgAtivo());
            } else {

                statement.setInt(4, 1);
            }

            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.err.println("Erro: Violação de chave única. Certifique-se de que a sequência 'seq_tb_ps_login' está configurada corretamente.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao adicionar login", e);
        }
    }

    public Optional<Login> find(String cdLogin, String dsSenha) throws SQLException {
        String sql = "SELECT * FROM t_gs_login WHERE cdLogin = ? AND dsSenha = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdLogin);
            statement.setString(2, dsSenha);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    Login login = new Login(
                            rs.getInt("cdLogin"),
                            rs.getString("dsEmail"),
                            rs.getString("dsSenha"),
                            rs.getInt("fgAtivo"));
                    return Optional.of(login);
                }
            }
        }
        return Optional.empty();
    }

    public Login login(String Email) throws SQLException {
        String sql = "SELECT * FROM T_GS_LOGIN WHERE dsEmail = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            try {
                statement.setString(1, Email);


            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("email inválido", e);
            }

            try (ResultSet rs = statement.executeQuery()) {
                Login login = new Login();

                if (rs.next()) {
                    login.setCdLogin(rs.getInt("cdLOGIN"));
                    login.setDsEmail(String.valueOf(rs.getLong("dsEmail")));
                    login.setDsSenha(rs.getString("DSSENHA"));
                    login.setFgAtivo(Integer.valueOf(rs.getString("fgAtivo")));
                }

                return login;
            }
        }

    }

    public void update(Login login) throws SQLException {
        String sql = "UPDATE t_gs_login SET dsEmail = ?, dsSenha = ?, fgAtivo = ? WHERE cdLogin = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, login.getDsEmail());
            statement.setString(2, login.getDsSenha());
            statement.setInt(3, login.getFgAtivo());
            statement.setInt(4, login.getCdLogin());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void delete(String cdLogin) throws SQLException {
        String sql = "DELETE FROM t_gs_login WHERE cdLogin = ?";

        try (Connection conn = DatabaseFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, cdLogin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }


}
