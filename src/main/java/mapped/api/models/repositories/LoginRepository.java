package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LoginRepository {

    public void add(Login login) throws SQLException {
        var sql = "INSERT INTO t_gs_login (cdLogin, dsEmail, dsSenha, fgAtivo) VALUES (?,?,?,?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, login.getCdLogin());
            statement.setString(2, login.getDsEmail());
            statement.setString(3, login.getDsSenha());
            statement.setInt(4, login.getFgAtivo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<Login> find(String cdLogin, String dsSenha) throws SQLException {
        var sql = "SELECT * FROM t_gs_login WHERE cdLogin = ? AND dsSenha = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, cdLogin);
            statement.setString(2, dsSenha);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    var login = new Login(
                            rs.getInt("cdLogin"),
                            rs.getString("dsEmail"),
                            rs.getString("dsSenha"),
                            rs.getInt("fgAtivo")
                    );
                    return Optional.of(login);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return Optional.empty();
    }
    public void update(Login login) throws SQLException {
        var sql = "UPDATE t_gs_login SET dsEmail = ?, dsSenha = ?, fgAtivo = ? WHERE cdLogin = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
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
        var sql = "DELETE FROM t_gs_login WHERE cdLogin = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, cdLogin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
