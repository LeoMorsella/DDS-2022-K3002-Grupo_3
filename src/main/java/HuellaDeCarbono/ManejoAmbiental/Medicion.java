package HuellaDeCarbono.ManejoAmbiental;

public class Medicion {

         private  String actividad;
         private  String tipoDeConsumo;
         private String valor;
        private  String periodicidad;
        private String periodoImputacion;

        public Medicion(String actividad, String tipoDeConsumo, String valor, String periodicidad, String periodoImputacion) {
            this.actividad = actividad;
            this.tipoDeConsumo = tipoDeConsumo;
            this.valor = valor;
            this.periodicidad = periodicidad;
            this.periodoImputacion = periodoImputacion;
        }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTipoDeConsumo() {
        return tipoDeConsumo;
    }

    public void setTipoDeConsumo(String tipoDeConsumo) {
        this.tipoDeConsumo = tipoDeConsumo;
    }

    public Double getValor() {
        return Double.parseDouble(valor);
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getPeriodoImputacion() {
        return periodoImputacion;
    }

    public void setPeriodoImputacion(String periodoImputacion) {
        this.periodoImputacion = periodoImputacion;
    }

    }


