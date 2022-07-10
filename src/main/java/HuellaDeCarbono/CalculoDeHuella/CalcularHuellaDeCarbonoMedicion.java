package HuellaDeCarbono.CalculoDeHuella;

import HuellaDeCarbono.CargaDeMediciones.DatoDeActividad;

import java.util.List;

public class CalcularHuellaDeCarbonoMedicion {
    static public Double calcularHCMedicionEstandar(DatoDeActividad medicion){
        Double HC = 0.0;
        Double FE = FactoresDeEmision.getFactores().getFE(medicion.getActividad());
        Double valor = medicion.getValor();
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
    static public Double calcularHCMedicion(List<DatoDeActividad> mediciones,Double k) {
    Double HCTotal = 0.0;
    Double peso = 0.0;
    Double distancia = 0.0;
        for (DatoDeActividad medicion : mediciones) {
            if (medicion.getActividad() != "Logística de productos y resitudos") {
                HCTotal += calcularHCMedicionEstandar(medicion);
            }
            else {
                if(medicion.getUnidad() == "Distancia Medio Recorrida")
                    distancia = medicion.getValor();
                else if (medicion.getUnidad() == "Peso Total Transportado")
                    peso = medicion.getValor();
            }
            //Problema para asignar FE acá porque el medio se registra como un double
            //ya que aparece en un campo valor de la medicion
            HCTotal += calcularHCMedicionLogistica(distancia, peso, medicion.getPeriodicidad(), 1.0, k);
        }
        return HCTotal;
    }
}
