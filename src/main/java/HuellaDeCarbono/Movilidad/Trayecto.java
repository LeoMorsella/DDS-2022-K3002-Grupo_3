package HuellaDeCarbono.Movilidad;

import HuellaDeCarbono.CalculoDeDistancias.APIDistanciaService;
import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.MedioDeTransporte.MedioMotorizado;
import HuellaDeCarbono.ManejoAmbiental.Ubicacion;
import HuellaDeCarbono.Repositorios.RepositorioTrayectos;

public class Trayecto {
    private Ubicacion puntoPartida;
    private Ubicacion puntoLlegada;
    private Medio medioTransporte;


    static public Trayecto getTrayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        Trayecto trayectoNuevo = new Trayecto(salida, llegada, medio);
        if(medio == new MedioMotorizado()){
            RepositorioTrayectos.getRepositorio().agregarTrayecto(trayectoNuevo);
        }
        return trayectoNuevo;
    }
    public Trayecto(Ubicacion salida, Ubicacion llegada, Medio medio){
        this.puntoPartida = salida;
        this.puntoLlegada = llegada;
        this.medioTransporte = medio;
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
