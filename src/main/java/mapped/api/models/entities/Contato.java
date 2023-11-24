package mapped.api.models.entities;

import java.util.Date;

public class Contato {

    private int cdContato;
    private String nmContato;
    private int nrDDI;
    private int nrDDD;
    private int nrTelefone;
    private Date dtCadastro;
    private int cdUsuario;
    private int cdTipoContato;

    public Contato() {
    }

    public Contato(int cdContato, String nmContato, int nrDDI, int nrDDD, int nrTelefone, Date dtCadastro, int cdUsuario, int cdTipoContato) {
        this.cdContato = cdContato;
        this.nmContato = nmContato;
        this.nrDDI = nrDDI;
        this.nrDDD = nrDDD;
        this.nrTelefone = nrTelefone;
        this.dtCadastro = dtCadastro;
        this.cdUsuario = cdUsuario;
        this.cdTipoContato = cdTipoContato;
    }

    public int getCdContato() {
        return cdContato;
    }

    public void setCdContato(int cdContato) {
        this.cdContato = cdContato;
    }

    public String getNmContato() {
        return nmContato;
    }

    public void setNmContato(String nmContato) {
        this.nmContato = nmContato;
    }

    public int getNrDDI() {
        return nrDDI;
    }

    public void setNrDDI(int nrDDI) {
        this.nrDDI = nrDDI;
    }

    public int getNrDDD() {
        return nrDDD;
    }

    public void setNrDDD(int nrDDD) {
        this.nrDDD = nrDDD;
    }

    public int getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(int nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public int getCdTipoContato() {
        return cdTipoContato;
    }

    public void setCdTipoContato(int cdTipoContato) {
        this.cdTipoContato = cdTipoContato;
    }
}
