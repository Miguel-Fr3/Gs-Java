package mapped.api.models.entities;

public class Bairro {

    private Integer cdBairro;
    private String nmBairro;
    private String nmZonaBairro;
    private int cdCidade;

    public Bairro() {
    }

    public Bairro(Integer cdBairro, String nmBairro, String nmZonaBairro, int cdCidade) {
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

    public int getCdCidade() {
        return cdCidade;
    }

    public void setCdCidade(int cdCidade) {
        this.cdCidade = cdCidade;
    }
}
