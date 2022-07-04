package HuellaDeCarbono.CalculoDeHuella;

import HuellaDeCarbono.ManejoAmbiental.Medicion;


public class CalcularHuellaDeCarbono {
    private Double k;

    private static CalcularHuellaDeCarbono instance = new CalcularHuellaDeCarbono();

    public static CalcularHuellaDeCarbono getCalculadorDeHC() {
        return instance;
    }

    public HuellaDeCarbono calcularHuellaDeCarbono(Medicion medicion) {
        Double HC = 0.0;
        String actividad = medicion.getActividad();
        Double valor = medicion.getValor();
        FactoresDeEmision factoresDeEmision = FactoresDeEmision.getFactores();
        if (actividad != "Logísitica de productos y residuos") {
            if (actividad != "Combustion Móvil") {
                HC = valor * factoresDeEmision.getFE(medicion.getTipoDeConsumo());
            }
            /*else{
                HC = medicion.getValor() * factoresDeEmision.getFE(medicion.getTipoDeTransporte());
            }
            Acá es el problema con el medio de transporte*/
        }
        else {
            //Calculo de huella en logistica
        }
        return new HuellaDeCarbono(medicion, HC);
    }

    public Double getK() {
        return k;
    }

    public void setK(Double k) {
        this.k = k;
    }
}
