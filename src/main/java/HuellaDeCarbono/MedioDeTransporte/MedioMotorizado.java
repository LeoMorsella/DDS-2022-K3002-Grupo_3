package HuellaDeCarbono.MedioDeTransporte;

import HuellaDeCarbono.CalculoDeHuella.FactoresDeEmision;

public class MedioMotorizado extends Medio {

    private TipoVehiculoMotorizado tipoVehiculoMotorizado;
    private TipoCombustible tipoCombustible;
    private String patente;
    private String ID = "MM";
    private Boolean esServicioContratado;
    private String tipoServicio;

    public String getID() {
        return ID;
    }

    public String getTipo() {
        return String.valueOf(tipoVehiculoMotorizado);
    }

    public void setTipoVehiculoMotorizado(TipoVehiculoMotorizado tipoVehiculoMotorizado) {
        this.tipoVehiculoMotorizado = tipoVehiculoMotorizado;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(TipoCombustible tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public Boolean getEsServicioContratado() {
        return esServicioContratado;
    }

    public void setEsServicioContratado(Boolean esServicioContratado) {
        this.esServicioContratado = esServicioContratado;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Double getFE() {
        return null; // TODO
    }
}
