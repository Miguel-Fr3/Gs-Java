package mapped.api.models.entities;

public class Bairro {

    private Integer cdBairro;
    private String nmBairro;
    private String nmZonaBairro;
    private String cdCidade;

    public Bairro() {
    }

    public Bairro(Integer cdBairro, String nmBairro, String nmZonaBairro, String cdCidade) {
        this.cdBairro = cdBairro;
        this.nmBairro = nmBairro;
        this.nmZonaBairro = nmZonaBairro;
        this.cdCidade = cdCidade;
    }

    public Integer getCdBairro() {
        return cdBairro;
    }

    public void setCdBairro(Integer cdBairro) {
        this.cdBairro = cdBairro;
    }

    public String getNmBairro() {
        return nmBairro;
    }

    public void setNmBairro(String nmBairro) {
        this.nmBairro = nmBairro;
    }

    public String getNmZonaBairro() {
        return nmZonaBairro;
    }

    public void setNmZonaBairro(String nmZonaBairro) {
        this.nmZonaBairro = nmZonaBairro;
    }

    public String getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(String cdCidade) {
        this.cdCidade = cdCidade;
    }
}
