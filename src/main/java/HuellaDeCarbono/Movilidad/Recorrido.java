package HuellaDeCarbono.Movilidad;

import HuellaDeCarbono.ManejoAmbiental.Miembro;
import HuellaDeCarbono.Repositorios.RepositorioRecorrido;

import java.util.ArrayList;
import java.util.Date;

public class Recorrido {

    private ArrayList<Trayecto> trayectos;

    private Double factorDeUso = null;

    private Date fechaDeInicio = null;

    public ArrayList<Trayecto> getTrayectos() {
        return trayectos;
    }

    public Recorrido(ArrayList<Trayecto> trayectos, Double unFactorDeUso) {
        this.trayectos = trayectos;
        this.factorDeUso = unFactorDeUso;
    }

    public static Recorrido nuevoRecorrido(ArrayList<Trayecto> trayectos, Double unFactorDeUso){
        Recorrido nuevoRecorrido = new Recorrido(trayectos, unFactorDeUso);
        System.out.println(nuevoRecorrido.getFactorDeUso());
        //RepositorioRecorrido.getRepositorio().agregarRecorrido(nuevoRecorrido);
        return nuevoRecorrido;
    }

    public Double getFactorDeUso() {
        return factorDeUso;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setTrayectos(ArrayList<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    public void asociarA(Miembro miembro, Double factorDeUso, Date fechaDeInicio){
        this.factorDeUso = factorDeUso;
        this.fechaDeInicio = fechaDeInicio;
        miembro.getRecorridos().add(this);
    }

    public void addTrayectos(ArrayList<Trayecto> nuevosTrayectos){
        for(Trayecto trayecto : nuevosTrayectos) trayectos.add(trayecto);
    }

    public Double distanciaTotal() throws Exception {
        Double distanciaTotal = Double.parseDouble("0");
        for (Trayecto trayecto : trayectos){
            distanciaTotal = distanciaTotal + trayecto.distanciaMedia();
        }
        return distanciaTotal;
    }

}

