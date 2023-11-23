package mapped.api.models.entities;

public class TipoContato {
    private String cdTipoContato;
    private String nmTipoContato;
    private int dtInicio;
    private int dtFim;

    public TipoContato() {
    }

    public TipoContato(String cdTipoContato, String nmTipoContato, int dtInicio, int dtFim) {
        this.cdTipoContato = cdTipoContato;
        this.nmTipoContato = nmTipoContato;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public String getCdTipoContato() {
        return cdTipoContato;
    }

    public void setCdTipoContato(String cdTipoContato) {
        this.cdTipoContato = cdTipoContato;
    }

    public String getNmTipoContato() {
        return nmTipoContato;
    }

    public void setNmTipoContato(String nmTipoContato) {
        this.nmTipoContato = nmTipoContato;
    }

    public int getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(int dtInicio) {
        this.dtInicio = dtInicio;
    }

    public int getDtFim() {
        return dtFim;
    }

    public void setDtFim(int dtFim) {
        this.dtFim = dtFim;
    }
}
