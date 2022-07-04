package HuellaDeCarbono.CalculoDeHuella;

import HuellaDeCarbono.Repositorios.RepositorioOrganizaciones;

import java.util.HashMap;

public class FactoresDeEmision {
    private HashMap <String, Float> FE = new HashMap<String, Float>();
    private static FactoresDeEmision instance = new FactoresDeEmision();

    public static FactoresDeEmision getFactores() {
        return instance;
    }

    //Se pueden cargar FE con tipos de consumo o con medios de transporte

    public void setFE(String claveDeFE, Float factorDeEmision){
        FE.put(claveDeFE, factorDeEmision);
    }

    public Float getFE(String claveDeFE){
        return FE.get(claveDeFE);
    }
}
