package mapped.api.models.entities;

public class Cidade {

    private String cdCidade;
    private String nmCidade;
    private String cdEstado;

    public Cidade() {
    }

    public Cidade(String cdCidade, String nmCidade, String cdEstado) {
        this.cdCidade = cdCidade;
        this.nmCidade = nmCidade;
        this.cdEstado = cdEstado;
    }

    public String getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(String cdCidade) {
        this.cdCidade = cdCidade;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public String getCdEstado() {
        return cdEstado;
    }

    public void setCdEstado(String cdEstado) {
        this.cdEstado = cdEstado;
    }
}
