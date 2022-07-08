package HuellaDeCarbono.CalculoDeHuella;

public class HuellaDeCarbono {

    private Medicion medicion;

    private Double HC;

    public HuellaDeCarbono(Medicion medicion, Double HC) {
        this.medicion = medicion;
        this.HC = HC;
    }

    public Medicion getMedicion() {
        return medicion;
    }

    public void setMedicion(Medicion medicion) {
        this.medicion = medicion;
    }

    public Double getHC() {
        return HC;
    }

    public void setHC(Double HC) {
        this.HC = HC;
    }
}
