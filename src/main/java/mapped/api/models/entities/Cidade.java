package mapped.api.models.entities;

public class Cidade {

    private int cdCidade;
    private String nmCidade;
    private int cdEstado;

    public Cidade() {
    }

    public Cidade(int cdCidade, String nmCidade, int cdEstado) {
        this.cdCidade = cdCidade;
        this.nmCidade = nmCidade;
        this.cdEstado = cdEstado;
    }

    public int getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(int cdCidade) {
        this.cdCidade = cdCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public int getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(int cdEstado) {
        this.cdEstado = cdEstado;
    }
}
