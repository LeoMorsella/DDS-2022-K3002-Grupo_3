package HuellaDeCarbono.MedioDeTransporte;

public class MedioMotorizado extends Medio {
    private TipoVehiculoMotorizado tipoVehiculoMotorizado;
    private TipoCombustible tipoCombustible;
    private String patente;
    private String ID = "MM";
    private Boolean esVehiculoMotorizado;
    private TipoServicio tipoServicio;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public TipoVehiculoMotorizado getTipoVehiculoMotorizado() {
        return tipoVehiculoMotorizado;
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

    public Boolean getEsVehiculoMotorizado() {
        return esVehiculoMotorizado;
    }

    public void setEsVehiculoMotorizado(Boolean esVehiculoMotorizado) {
        this.esVehiculoMotorizado = esVehiculoMotorizado;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(TipoServicio tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
