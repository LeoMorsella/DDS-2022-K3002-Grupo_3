package HuellaDeCarbono.Movilidad;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.Organizacion.Ubicacion;

import static HuellaDeCarbono.Repositorios.RepositorioTrayectos.getRepositorio;

public class Trayecto {
    Ubicacion puntoPartida;
    Ubicacion puntoLlegada;
    Medio medioTransporte;


    public Trayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        Trayecto nuevoTrayecto = new Trayecto(salida, llegada, medio);
        if(medioTransporte.getID()=="MM") {
            getRepositorio().agregarTrayecto(nuevoTrayecto);
        }
    }

    public Ubicacion getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(Ubicacion puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public Ubicacion getPuntoLlegada() {
        return puntoLlegada;
    }

    public void setPuntoLlegada(Ubicacion puntoLlegada) {
        this.puntoLlegada = puntoLlegada;
    }

    public Medio getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(Medio medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    public Float distanciaMedia() throws Exception {
        APIDistanciaService distanciaService = new APIDistanciaService();
        return distanciaService.medirDistancia(puntoPartida, puntoLlegada);
    }
}
