package mapped.api.models.entities;

import java.util.Date;

public class TipoContato {
    private Integer cdTipoContato;
    private String nmTipoContato;
    private Date dtInicio;
    private Date dtFim;

    public TipoContato() {
    }

    public TipoContato(Integer cdTipoContato, String nmTipoContato, Date dtInicio, Date dtFim) {
        this.cdTipoContato = cdTipoContato;
        this.nmTipoContato = nmTipoContato;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
    }

    public Integer getCdTipoContato() {
        return cdTipoContato;
    }

    public void setCdTipoContato(Integer cdTipoContato) {
        this.cdTipoContato = cdTipoContato;
    }

    public String getNmTipoContato() {
        return nmTipoContato;
    }

    public void setNmTipoContato(String nmTipoContato) {
        this.nmTipoContato = nmTipoContato;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }
}
