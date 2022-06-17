package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTrayectos {
  private static RepositorioTrayectos instance = new RepositorioTrayectos();
  private List<Trayecto> trayectos;

  private RepositorioTrayectos(){
    this.trayectos = new ArrayList<>();
  }

  public static RepositorioTrayectos getRepositorio(){
    return instance;
  }

  public List<Trayecto> getTrayectos() {
    return trayectos;
  }

  public void setTrayectos(List<Trayecto> trayectos) {
    this.trayectos = trayectos;
  }

  public void agregarTrayecto (Trayecto trayecto){
    this.trayectos.add(trayecto);
  }

}

