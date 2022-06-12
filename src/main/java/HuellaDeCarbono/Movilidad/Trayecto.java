package HuellaDeCarbono.Movilidad;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Organizacion.Ubicacion;

public class Trayecto {
    Ubicacion puntoPartida;
    Ubicacion puntoLlegada;
    Medio medioTransporte;

    public Trayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        this.puntoPartida = salida;
        this.puntoLlegada = llegada;
        this.medioTransporte = medio;
    }

    public Distancia distanciaMedia() throws Exception {
        APIDistanciaService distanciaService = new APIDistanciaService()
        distanciaService.medirDistancia(puntoPartida, puntoLlegada);
    }
}
