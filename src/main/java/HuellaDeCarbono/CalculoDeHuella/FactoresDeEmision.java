package HuellaDeCarbono.CalculoDeHuella;

import java.util.HashMap;

public class FactoresDeEmision {
    private HashMap<String, Double> FE = new HashMap<String, Double>();
    private static FactoresDeEmision instance = new FactoresDeEmision();

    public static FactoresDeEmision getFactores() {
        return instance;
    }

    //Se pueden cargar FE con tipos de consumo o con medios de transporte

    public void setFE(String claveDeFE, Double factorDeEmision){
        FE.put(claveDeFE, factorDeEmision);
    }

    public Double getFE(String claveDeFE){
        return FE.get(claveDeFE);
    }
}
