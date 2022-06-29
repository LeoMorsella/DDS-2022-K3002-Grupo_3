package HuellaDeCarbono.MedioDeTransporte;

import HuellaDeCarbono.CalculoDeDistancias.Distancia;
import HuellaDeCarbono.ManejoAmbiental.Ubicacion;

public class Parada {
    private String nombre;
    private Ubicacion ubicacion;

    private Distancia distanciaAProximaParada;

    public Parada(String nom, Ubicacion ubi){
        this.nombre = nom;
        this.ubicacion = ubi;
    }

    public Float distancaAProximaParada() throws Exception {
        if (distanciaAProximaParada.getValor()!= 0) {
            return distanciaAProximaParada.getValor();
        }
        else{
            throw new RuntimeException("No hay siguiente parada (Parada Terminal)");
        }
    }
}
