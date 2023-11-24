package mapped.api.services;

import mapped.api.models.entities.Login;
import mapped.api.models.repositories.LoginRepository;

import java.sql.SQLException;
import java.util.Objects;

public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService() {
        this.loginRepository = new LoginRepository();
    }

    public boolean login(String Email, String Senha) throws Exception {
        try {
            if (Email == null || Senha == null) {
                throw new IllegalArgumentException("Email e senha não podem ser nulos.");
            }

            Login login = this.loginRepository.login(Email);

            return Objects.equals(login.getDsSenha(), Senha) && Objects.equals(login.getDsEmail(), Email);
        } catch (SQLException e) {
            e.printStackTrace(); // ou logar a exceção
            throw new Exception("Erro ao autenticar usuário: " + e.getMessage());
        }
    }
}