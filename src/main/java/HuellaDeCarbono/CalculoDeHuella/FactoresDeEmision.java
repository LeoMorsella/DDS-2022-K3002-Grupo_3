package HuellaDeCarbono.CalculoDeHuella;

import java.util.HashMap;

public class FactoresDeEmision {
    private HashMap<String, Double> FE = new HashMap<String, Double>();
    /*
    public final class Singleton {
        private static Singleton instance;
        public String value;

        private Singleton(String value) {
            // The following code emulates slow initialization.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            this.value = value;
        }

        public static Singleton getInstance(String value) {
            if (instance == null) {
                instance = new Singleton(value);
            }
            return instance;
        }
    }*/
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
