package mapped.api.models.entities;

public class Logradouro {
    private int cdLogradouro;
    private String nmRua;
    private int nrCep;
    private int cdBairro;

    public Logradouro() {
    }

    public Logradouro(int cdLogradouro, String nmRua, int nrCep, int cdBairro) {
        this.cdLogradouro = cdLogradouro;
        this.nmRua = nmRua;
        this.nrCep = nrCep;
        this.cdBairro = cdBairro;
    }

    public int getCdLogradouro() {
        return cdLogradouro;
    }

    public void setCdLogradouro(int cdLogradouro) {
        this.cdLogradouro = cdLogradouro;
    }

    public String getNmRua() {
        return nmRua;
    }

    public void setNmRua(String nmRua) {
        this.nmRua = nmRua;
    }

    public int getNrCep() {
        return nrCep;
    }

    public void setNrCep(int nrCep) {
        this.nrCep = nrCep;
    }

    public int getCdBairro() {
        return cdBairro;
    }

    public void setCdBairro(int cdBairro) {
        this.cdBairro = cdBairro;
    }
}
