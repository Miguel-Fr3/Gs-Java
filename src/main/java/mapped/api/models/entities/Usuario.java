package mapped.api.models.entities;

public class Usuario {

    private Integer cdUsuario;
    private String nmUsuario;
    private int dtNascimento;
    private int dtCadastro;
    private String nrRG;
    private String rua;
    private String dsEscolaridade;
    private String dsEstadoCivil;
    private String dsNacionalidade;
    private String dsProfissao;
    private Integer fgAtivo;
    private String cdEndereco;
    private String cdLogin;
    private String cdPaciente;

    public Usuario() {
    }

    public Usuario(Integer cdUsuario, String nmUsuario, int dtNascimento, int dtCadastro, String nrRG, String rua,
                   String dsEscolaridade, String dsEstadoCivil, String dsNacionalidade, String dsProfissao,
                   Integer fgAtivo, String cdEndereco, String cdLogin, String cdPaciente) {
        this.cdUsuario = cdUsuario;
        this.nmUsuario = nmUsuario;
        this.dtNascimento = dtNascimento;
        this.dtCadastro = dtCadastro;
        this.nrRG = nrRG;
        this.rua = rua;
        this.dsEscolaridade = dsEscolaridade;
        this.dsEstadoCivil = dsEstadoCivil;
        this.dsNacionalidade = dsNacionalidade;
        this.dsProfissao = dsProfissao;
        this.fgAtivo = fgAtivo;
        this.cdEndereco = cdEndereco;
        this.cdLogin = cdLogin;
        this.cdPaciente = cdPaciente;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public int getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(int dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public int getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(int dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getNrRG() {
        return nrRG;
    }

    public void setNrRG(String nrRG) {
        this.nrRG = nrRG;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getDsEscolaridade() {
        return dsEscolaridade;
    }

    public void setDsEscolaridade(String dsEscolaridade) {
        this.dsEscolaridade = dsEscolaridade;
    }

    public String getDsEstadoCivil() {
        return dsEstadoCivil;
    }

    public void setDsEstadoCivil(String dsEstadoCivil) {
        this.dsEstadoCivil = dsEstadoCivil;
    }

    public String getDsNacionalidade() {
        return dsNacionalidade;
    }

    public void setDsNacionalidade(String dsNacionalidade) {
        this.dsNacionalidade = dsNacionalidade;
    }

    public String getDsProfissao() {
        return dsProfissao;
    }

    public void setDsProfissao(String dsProfissao) {
        this.dsProfissao = dsProfissao;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }

    public String getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(String cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public String getCdLogin() {
        return cdLogin;
    }

    public void setCdLogin(String cdLogin) {
        this.cdLogin = cdLogin;
    }

    public String getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(String cdPaciente) {
        this.cdPaciente = cdPaciente;
    }
}
