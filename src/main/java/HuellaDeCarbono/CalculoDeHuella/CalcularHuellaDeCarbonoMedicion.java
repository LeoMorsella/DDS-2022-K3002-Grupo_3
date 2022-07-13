package HuellaDeCarbono.CalculoDeHuella;

import HuellaDeCarbono.CargaDeMediciones.DatoDeMedicion;

import java.util.List;

public class CalcularHuellaDeCarbonoMedicion {
    static public Double calcularHCMedicionEstandar(DatoDeMedicion datoDeMedicion){
        Double HC = 0.0;
        Double FE = FactoresDeEmision.getInstance().getFE(datoDeMedicion.getActividad());
        Double valor = (Double) datoDeMedicion.getValor();
        if(datoDeMedicion.getPeriodicidad() == "mensual"){
            return HC = valor * FE;
        }
        else{
            return HC = valor/12 * FE;
        }
    }

    static public Double calcularHCMedicionLogistica (Double distancia, Double peso, String periocidad, Double FE, Double k) {
        Double HC = 0.0;
        if(periocidad == "Mensual"){
            return HC = distancia * peso * k * FE;
        }
        else{
            return HC = (distancia * peso)/12 * k * FE;
        }
    }
    static public Double calcularHCMedicion(List<DatoDeMedicion> mediciones, Double k) {
    Double HCTotal = 0.0;
    Double peso = 0.0;
    Double distancia = 0.0;
    Double FE = 0.0;
        for (DatoDeMedicion datoDeMedicion : mediciones) {
            if (datoDeMedicion.getActividad() != "Logística de productos y resitudos") {
                HCTotal += calcularHCMedicionEstandar(datoDeMedicion);
            }
            else {
                if(datoDeMedicion.getTipoDeConsumo() == "Distancia Medio Recorrida")
                    distancia =(Double) datoDeMedicion.getValor();
                else if (datoDeMedicion.getTipoDeConsumo() == "Peso Total Transportado")
                    peso = (Double) datoDeMedicion.getValor();
                else if (datoDeMedicion.getTipoDeConsumo() == "Medio de Transporte")
                    FE = FactoresDeEmision.getInstance().getFE((String) datoDeMedicion.getValor());
            }
            HCTotal += calcularHCMedicionLogistica(distancia, peso, datoDeMedicion.getPeriodicidad(), FE, k);
        }
        return HCTotal;
    }
}
