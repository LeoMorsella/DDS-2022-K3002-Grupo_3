package HuellaDeCarbono.MedioDeTransporte;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.Organizacion.Ubicacion;

public class Parada {
    String nombre;
    Ubicacion ubicacion;

    Parada siguienteParada;

    public Parada(String nom, Ubicacion ubi){
        this.nombre = nom;
        this.ubicacion = ubi;
    }

    public Distancia distancaAProximaParada(){
        APIDistanciaService distanciaService = new APIDistanciaService()
        if (siguienteParada!= null) {
            return distanciaService.medirDistancia(this.ubicacion, siguienteParada.ubicacion);
        }
        else{
            throw new RuntimeException("No hay siguiente parada (Parada Terminal)");
        }
    }
}
