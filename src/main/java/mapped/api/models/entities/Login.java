package mapped.api.models.entities;

public class Login {
    private String cdLogin;
    private String dsEmail;
    private String dsSenha;
    private Integer fgAtivo;

    public Login() {
    }

    public Login(String cdLogin, String dsEmail, String dsSenha, Integer fgAtivo) {
        this.cdLogin = cdLogin;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;
        this.fgAtivo = fgAtivo;
    }

    public String getCdLogin() {
        return cdLogin;
    }

    public void setCdLogin(String cdLogin) {
        this.cdLogin = cdLogin;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    @Override
    public String toString() {
        return "Login{" +
                "cdLogin='" + cdLogin + '\'' +
                ", dsEmail='" + dsEmail + '\'' +
                ", dsSenha='" + dsSenha + '\'' +
                ", fgAtivo=" + fgAtivo +
                '}';
    }
}
