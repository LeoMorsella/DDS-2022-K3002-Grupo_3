package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.Parada;

import java.util.ArrayList;
import java.util.List;

public class RepositorioParadas {
  private static RepositorioParadas instance = new RepositorioParadas();
  public List<Parada> paradas;


  private RepositorioParadas() {
    this.paradas = new ArrayList<>();

  }

  public static RepositorioParadas getParadas() {
    return instance;
  }

  public void agregarParada(Parada par){
    this.paradas.add(par);
  }
}
