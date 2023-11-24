package mapped.api.models.entities;

public class Login {
    private int cdLogin;
    private String dsEmail;
    private String dsSenha;
    private Integer fgAtivo;

    public Login() {

        this.fgAtivo = 1;
    }

    public Login(int cdLogin, String dsEmail, String dsSenha, Integer fgAtivo) {
        this.cdLogin = cdLogin;
        this.dsEmail = dsEmail;
        this.dsSenha = dsSenha;


        this.fgAtivo = (fgAtivo != null) ? fgAtivo : 1;
    }

    public Login(int cdLogin, String dsEmail, String dsSenha) {
    }

    public int getCdLogin() {
        return cdLogin;
    }

    public void setCdLogin(int cdLogin) {
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
