package HuellaDeCarbono.Repositorios;

import java.util.ArrayList;
import java.util.List;

public class RepositorioServicioContratado {
  private static RepositorioServicioContratado instance = new RepositorioServicioContratado();
  private List<TipoServicio> servicios;


  private RepositorioServicioContratado() {
    this.servicios = new ArrayList<TipoServicio>();

  }

  public List<TipoServicio> getServicios() {
    return servicios;
  }

  public void setServicios(List<TipoServicio> servicios) {
    this.servicios = servicios;
  }

  public static RepositorioServicioContratado getRepositorio() {
    return instance;
  }

  public void agregarServicioContratado(TipoServicio ser){
    this.servicios.add(ser);
  }
}
