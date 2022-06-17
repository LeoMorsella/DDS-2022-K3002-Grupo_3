package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.Movilidad.Trayecto;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTrayectos {
  private static RepositorioTrayectos instance = new RepositorioTrayectos();
  public List<Trayecto> trayectos;

  private RepositorioTrayectos(){
    this.trayectos = new ArrayList<>();
  }

  public static RepositorioTrayectos getRepositorio(){
    return instance;
  }

  public void agregarTrayecto (Trayecto trayecto){
    this.trayectos.add(trayecto);
  }

}

