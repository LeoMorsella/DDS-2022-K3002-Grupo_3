package HuellaDeCarbono.CalculoDeHuella;

import HuellaDeCarbono.CargaDeMediciones.Medicion;

import java.util.List;

public class CalcularHuellaDeCarbonoMedicion {
    static public Double calcularHCMedicionEstandar(Medicion medicion){
        Double HC = 0.0;
        Double FE = FactoresDeEmision.getFactores().getFE(medicion.getActividad());
        Double valor = (Double) medicion.getValor();
        if(medicion.getPeriodicidad() == "mensual"){
            return HC = valor * FE;
        }
        else{
            return HC = valor/12 * FE;
        }
    }

    static public Double calcularHCMedicionLogistica (Double distancia, Double peso, String periocidad, Double FE, Double k) {
        Double HC = 0.0;
        if(periocidad == "mensual"){
            return HC = distancia * peso * k * FE;
        }
        else{
            return HC = (distancia * peso)/12 * k * FE;
        }
    }
    static public Double calcularHCMedicion(List<Medicion> mediciones,Double k) {
    Double HCTotal = 0.0;
    Double peso = 0.0;
    Double distancia = 0.0;
    Double FE = 0.0;
        for (Medicion medicion : mediciones) {
            if (medicion.getActividad() != "Logística de productos y resitudos") {
                HCTotal += calcularHCMedicionEstandar(medicion);
            }
            else {
                if(medicion.getTipoDeConsumo() == "Distancia Medio Recorrida")
                    distancia =(Double) medicion.getValor();
                else if (medicion.getTipoDeConsumo() == "Peso Total Transportado")
                    peso = (Double) medicion.getValor();
                else if (medicion.getTipoDeConsumo() == "Medio de Transporte")
                    FE = FactoresDeEmision.getFactores().getFE((String) medicion.getValor());
            }
            HCTotal += calcularHCMedicionLogistica(distancia, peso, medicion.getPeriodicidad(), FE, k);
        }
        return HCTotal;
    }
}
