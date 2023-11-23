package mapped.api.models.repositories;

import mapped.api.database.infrastructure.DatabaseFactory;
import mapped.api.models.entities.Login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LoginRepository {

    public void add(Login login) throws SQLException {
        var sql = "INSERT INTO LOGIN (CD_LOGIN, DS_EMAIL, DS_SENHA, FG_ATIVO) VALUES (?,?,?,?)";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, login.getCdLogin());
            statement.setString(2, login.getDsEmail());
            statement.setString(3, login.getDsSenha());
            statement.setInt(4, login.getFgAtivo());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public Optional<Login> find(String cdLogin, String dsSenha) throws SQLException {
        var sql = "SELECT * FROM LOGIN WHERE CD_LOGIN = ? AND DS_SENHA = ?";

        try {
            var conn = DatabaseFactory.getConnection();
            var statement = conn.prepareStatement(sql);
            statement.setString(1, cdLogin);
            statement.setString(2, dsSenha);
            try {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    var login = new Login(
                            rs.getString("cdLogin"),
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

    public void update(Login login) {
    }

    public void delete(String cdLogin) {
    }
}
