package mapped.api.models.entities;

import java.util.Date;

public class Usuario {

    private Integer cdUsuario;
    private String nmUsuario;
    private Date dtNascimento;
    private Date dtCadastro;
    private Integer nrRG;
    private String dsEscolaridade;
    private String dsEstadoCivil;
    private String dsNacionalidade;
    private String dsProfissao;
    private Integer fgAtivo;
    private Integer cdEndereco;
    private Integer cdLogin;
    private Integer cdPaciente;

    public Usuario() {
    }

    public Usuario(Integer cdUsuario, String nmUsuario, Date dtNascimento, Date dtCadastro, Integer nrRG,
                   String dsEscolaridade, String dsEstadoCivil, String dsNacionalidade, String dsProfissao,
                   Integer fgAtivo, Integer cdEndereco, Integer cdLogin, Integer cdPaciente) {
        this.cdUsuario = cdUsuario;
        this.nmUsuario = nmUsuario;
        this.dtNascimento = dtNascimento;
        this.dtCadastro = dtCadastro;
        this.nrRG = nrRG;
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Integer getNrRG() {
        return nrRG;
    }

    public void setNrRG(Integer nrRG) {
        this.nrRG = nrRG;
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

    public Integer getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(Integer cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public Integer getCdLogin() {
        return cdLogin;
    }

    public void setCdLogin(Integer cdLogin) {
        this.cdLogin = cdLogin;
    }

    public Integer getCdPaciente() {
        return cdPaciente;
    }

    public void setCdPaciente(Integer cdPaciente) {
        this.cdPaciente = cdPaciente;
    }
}
