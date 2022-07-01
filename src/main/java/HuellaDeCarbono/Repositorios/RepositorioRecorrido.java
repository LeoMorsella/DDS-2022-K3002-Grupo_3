package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.Parada;
import HuellaDeCarbono.Movilidad.Recorrido;

import java.util.ArrayList;
import java.util.List;

public class RepositorioRecorrido {

    private static RepositorioRecorrido instance = new RepositorioRecorrido();
    private List<Parada> recorridos;
    private ArrayList<Recorrido> recorridoArrayList;

    private RepositorioRecorrido() {
        this.recorridos = new ArrayList<>();

    }

    public List<Parada> getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(List<Parada> recorridos) {
        this.recorridos = recorridos;
    }

    public static RepositorioRecorrido getRepositorio() {
        return instance;
    }

    public void agregarRecorrido (Recorrido recorrido) {
            recorridoArrayList.add(recorrido);
    }

}
