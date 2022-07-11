package HuellaDeCarbono.CargaDeMediciones;

public class Medicion {

         private  String actividad;
         private  String tipoDeConsumo;
         private String valor;
        private  String periodicidad;
        private String periodoImputacion;
        private String unidad;

        public Medicion(String actividad, String unidad, String tipoDeConsumo, String valor, String periodicidad, String periodoImputacion) {
            this.actividad = actividad;
            this.tipoDeConsumo = tipoDeConsumo;
            this.valor = valor;
            this.periodicidad = periodicidad;
            this.periodoImputacion = periodoImputacion;
            this. unidad = unidad;
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

    public Object getValor() {
            if(this.tipoDeConsumo != "Categoria de producto transportado" && this.tipoDeConsumo !=
                    "Medio de Transporte") return Double.parseDouble(valor);
            else return valor;
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

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Double calculoHuella() {
            return null; // TODO
    }
}


