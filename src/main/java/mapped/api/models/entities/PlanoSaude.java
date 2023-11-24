package mapped.api.models.entities;

import java.util.Date;

public class PlanoSaude {
    private Integer cdPlanoSaude;
    private String dsRazaoSocial;
    private String nmFantasia;
    private String dsPlanoSaude;
    private Integer nrCnpj;
    private String nmContato;
    private int nrTelefone;
    private Date dtCadastro;
    private Integer fgAtivo;

    public PlanoSaude() {
    }

    public PlanoSaude(Integer cdPlanoSaude, String dsRazaoSocial, String nmFantasia, String dsPlanoSaude, Integer nrCnpj,
                      String nmContato, int nrTelefone, Date dtCadastro, Integer fgAtivo) {
        this.cdPlanoSaude = cdPlanoSaude;
        this.dsRazaoSocial = dsRazaoSocial;
        this.nmFantasia = nmFantasia;
        this.dsPlanoSaude = dsPlanoSaude;
        this.nrCnpj = nrCnpj;
        this.nmContato = nmContato;
        this.nrTelefone = nrTelefone;
        this.dtCadastro = dtCadastro;
        this.fgAtivo = fgAtivo;
    }

    public Integer getCdPlanoSaude() {
        return cdPlanoSaude;
    }

    public void setCdPlanoSaude(Integer cdPlanoSaude) {
        this.cdPlanoSaude = cdPlanoSaude;
    }

    public String getDsRazaoSocial() {
        return dsRazaoSocial;
    }

    public void setDsRazaoSocial(String dsRazaoSocial) {
        this.dsRazaoSocial = dsRazaoSocial;
    }

    public String getNmFantasia() {
        return nmFantasia;
    }

    public void setNmFantasia(String nmFantasia) {
        this.nmFantasia = nmFantasia;
    }

    public String getDsPlanoSaude() {
        return dsPlanoSaude;
    }

    public void setDsPlanoSaude(String dsPlanoSaude) {
        this.dsPlanoSaude = dsPlanoSaude;
    }

    public String getNrCnpj() {
        return String.valueOf(nrCnpj);
    }

    public void setNrCnpj(Integer nrCnpj) {
        this.nrCnpj = nrCnpj;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public String getNrTelefone() {
        return String.valueOf(nrTelefone);
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = Integer.parseInt(nrTelefone);
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
