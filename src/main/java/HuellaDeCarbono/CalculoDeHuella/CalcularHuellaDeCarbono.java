package HuellaDeCarbono.CalculoDeHuella;


import HuellaDeCarbono.CargaDeMediciones.DatoDeActividad;

public class CalcularHuellaDeCarbono {
    private Double k;

    private static CalcularHuellaDeCarbono instance = new CalcularHuellaDeCarbono();

    public static CalcularHuellaDeCarbono getCalculadorDeHC() {
        return instance;
    }

    public Double calcularHuellaDeCarbono(DatoDeActividad medicion) {
        Double HC = 0.0;

        return HC;
    }

    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
    }
}
