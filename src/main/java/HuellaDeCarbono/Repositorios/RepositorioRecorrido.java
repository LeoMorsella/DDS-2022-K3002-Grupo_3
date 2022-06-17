package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.Parada;

import java.util.ArrayList;
import java.util.List;

public class RepositorioRecorrido {

    private static RepositorioRecorrido instance = new RepositorioRecorrido();
    private List<Parada> recorridos;

    private RepositorioRecorrido() {
        this.recorridos = new ArrayList<>();

    }
    public static RepositorioRecorrido getRecorridos() {
        return instance;
    }

}
