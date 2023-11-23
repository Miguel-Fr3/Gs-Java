package mapped.api.models.entities;

public class PlanoSaude {
    private String cdPlanoSaude;
    private String dsRazaoSocial;
    private String nmFantasia;
    private String dsPlanoSaude;
    private String nrCnpj;
    private String nmContato;
    private String nrTelefone;
    private int dtCadastro;
    private Integer fgAtivo;

    public PlanoSaude() {
    }

    public PlanoSaude(String cdPlanoSaude, String dsRazaoSocial, String nmFantasia, String dsPlanoSaude, String nrCnpj,
                      String nmContato, String nrTelefone, int dtCadastro, Integer fgAtivo) {
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

    public String getCdPlanoSaude() {
        return cdPlanoSaude;
    }

    public void setCdPlanoSaude(String cdPlanoSaude) {
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
        return nrCnpj;
    }

    public void setNrCnpj(String nrCnpj) {
        this.nrCnpj = nrCnpj;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public int getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(int dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Integer getFgAtivo() {
        return fgAtivo;
    }

    public void setFgAtivo(Integer fgAtivo) {
        this.fgAtivo = fgAtivo;
    }
}
