package HuellaDeCarbono.Movilidad;

import HuellaDeCarbono.ManejoAmbiental.Miembro;
import HuellaDeCarbono.Repositorios.RepositorioRecorrido;

import java.util.ArrayList;

public class Recorrido {

    private ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();

    public ArrayList<Trayecto> getTrayectos() {
        return trayectos;
    }

    private Recorrido(ArrayList<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public static Recorrido nuevoRecorrido(ArrayList<Trayecto> trayectos){
        Recorrido nuevoRecorrido = new Recorrido(trayectos);
        RepositorioRecorrido.getRepositorio().agregarRecorrido(nuevoRecorrido);
        return nuevoRecorrido;
    }

    public void setTrayectos(ArrayList<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public void asociarA(Miembro miembro){
        miembro.getRecorrido().add(trayectos);
    }

    public void addTrayectos(ArrayList<Trayecto> nuevosTrayectos){
        for(Trayecto trayecto : nuevosTrayectos) trayectos.add(trayecto);
    }

    public Float distanciaTotal() throws Exception {
        Float distanciaTotal = Float.parseFloat("0");
        for (Trayecto trayecto : trayectos){
            distanciaTotal = distanciaTotal + trayecto.distanciaMedia();
        }
        return distanciaTotal;
    }

}

