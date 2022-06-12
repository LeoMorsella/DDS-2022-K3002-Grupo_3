package HuellaDeCarbono.Movilidad;

import HuellaDeCarbono.Organizacion.Miembro;

import java.util.ArrayList;

public class Recorrido {

    ArrayList<Trayecto> trayectos;

    public void asociarA(Miembro miembro){
        miembro.recorrido.add(trayectos);
    }

    public void addTrayectos(ArrayList<Trayecto> nuevosTrayectos){
        for(Trayecto trayecto : nuevosTrayectos) trayectos.add(trayecto);
    }

    public Distancia distanciaTotal(){
        Distancia distanciaTotal = 0;
        for (Trayecto trayecto : trayectos){
            distanciaTotal = distanciaTotal + trayecto.distanciaMedia();
        }
        return distanciaTotal
    }

}

