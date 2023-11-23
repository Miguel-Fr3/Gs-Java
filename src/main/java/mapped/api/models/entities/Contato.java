package mapped.api.models.entities;

public class Contato {

    private String cdContato;
    private String nmContato;
    private String nrDDI;
    private String nrDDD;
    private String nrTelefone;
    private int dtCadastro;
    private String cdUsuario;
    private String cdTipoContato;

    public Contato() {
    }

    public Contato(String cdContato, String nmContato, String nrDDI, String nrDDD, String nrTelefone,
                   int dtCadastro, String cdUsuario, String cdTipoContato) {
        this.cdContato = cdContato;
        this.nmContato = nmContato;
        this.nrDDI = nrDDI;
        this.nrDDD = nrDDD;
        this.nrTelefone = nrTelefone;
        this.dtCadastro = dtCadastro;
        this.cdUsuario = cdUsuario;
        this.cdTipoContato = cdTipoContato;
    }

    public String getCdContato() {
        return cdContato;
    }

    public void setCdContato(String cdContato) {
        this.cdContato = cdContato;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public String getNrDDI() {
        return nrDDI;
    }

    public void setNrDDI(String nrDDI) {
        this.nrDDI = nrDDI;
    }

    public String getNrDDD() {
        return nrDDD;
    }

    public void setNrDDD(String nrDDD) {
        this.nrDDD = nrDDD;
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

    public String getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(String cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getCdTipoContato() {
        return cdTipoContato;
    }

    public void setCdTipoContato(String cdTipoContato) {
        this.cdTipoContato = cdTipoContato;
    }
}
