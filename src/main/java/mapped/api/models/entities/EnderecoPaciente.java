package mapped.api.models.entities;

public class EnderecoPaciente {

    private String cdEndereco;
    private String nrLogradouro;
    private String dsComplemento;
    private String dsPontoReferencia;
    private String cdLogradouro;

    public EnderecoPaciente() {
    }

    public EnderecoPaciente(String cdEndereco, String nrLogradouro, String dsComplemento,
                            String dsPontoReferencia, String cdLogradouro) {
        this.cdEndereco = cdEndereco;
        this.nrLogradouro = nrLogradouro;
        this.dsComplemento = dsComplemento;
        this.dsPontoReferencia = dsPontoReferencia;
        this.cdLogradouro = cdLogradouro;
    }

    public String getCdEndereco() {
        return cdEndereco;
    }

    public void setCdEndereco(String cdEndereco) {
        this.cdEndereco = cdEndereco;
    }

    public String getNrLogradouro() {
        return nrLogradouro;
    }

    public void setNrLogradouro(String nrLogradouro) {
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

    public String getCdLogradouro() {
        return cdLogradouro;
    }

    public void setCdLogradouro(String cdLogradouro) {
        this.cdLogradouro = cdLogradouro;
    }
}
