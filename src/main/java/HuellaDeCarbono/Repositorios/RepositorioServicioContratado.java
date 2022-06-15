package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.TipoServicio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioServicioContratado {
  private static RepositorioServicioContratado instance = new RepositorioServicioContratado();
  public List<TipoServicio> servicios;


  private RepositorioServicioContratado() {
    this.servicios = new ArrayList<TipoServicio>();

  }

  public static RepositorioServicioContratado getServiciosContratados() {
    return instance;
  }

  public void agregarServicioContratado(TipoServicio ser){
    this.servicios.add(ser);
  }
}
