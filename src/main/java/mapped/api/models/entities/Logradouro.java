package mapped.api.models.entities;

public class Logradouro {
    private String cdLogradouro;
    private String nmRua;
    private String nrCep;
    private String cdBairro;

    public Logradouro() {
    }

    public Logradouro(String cdLogradouro, String nmRua, String nrCep, String cdBairro) {
        this.cdLogradouro = cdLogradouro;
        this.nmRua = nmRua;
        this.nrCep = nrCep;
        this.cdBairro = cdBairro;
    }

    public String getCdLogradouro() {
        return cdLogradouro;
    }

    public void setCdLogradouro(String cdLogradouro) {
        this.cdLogradouro = cdLogradouro;
    }

    public String getNmRua() {
        return nmRua;
    }

    public void setNmRua(String nmRua) {
        this.nmRua = nmRua;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getCdBairro() {
        return cdBairro;
    }

    public void setCdBairro(String cdBairro) {
        this.cdBairro = cdBairro;
    }
}
