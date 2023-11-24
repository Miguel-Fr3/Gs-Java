package mapped.api.models.entities;

public class EnderecoPaciente {

    private int cdEndereco;
    private int nrLogradouro;
    private String dsComplemento;
    private String dsPontoReferencia;
    private int cdLogradouro;

    public EnderecoPaciente() {
    }

    public EnderecoPaciente(int cdEndereco, int nrLogradouro, String dsComplemento, String dsPontoReferencia, int cdLogradouro) {
        this.cdEndereco = cdEndereco;
        this.nrLogradouro = nrLogradouro;
        this.dsComplemento = dsComplemento;
        this.dsPontoReferencia = dsPontoReferencia;
        this.cdLogradouro = cdLogradouro;
    }

    public int getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(int cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public int getNrLogradouro() {
        return nrLogradouro;
    }

    public void setNrLogradouro(int nrLogradouro) {
        this.nrLogradouro = nrLogradouro;
    }

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public String getDsPontoReferencia() {
        return dsPontoReferencia;
    }

    public void setDsPontoReferencia(String dsPontoReferencia) {
        this.dsPontoReferencia = dsPontoReferencia;
    }

    public int getCdLogradouro() {
        return cdLogradouro;
    }

    public void setCdLogradouro(int cdLogradouro) {
        this.cdLogradouro = cdLogradouro;
    }
}
