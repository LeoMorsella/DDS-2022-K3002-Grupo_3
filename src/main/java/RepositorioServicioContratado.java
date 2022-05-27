import java.util.ArrayList;
import java.util.List;

public class RepositorioServicioContratado {
  private static RepositorioServicioContratado instance = new RepositorioServicioContratado();
  public List<ServicioContratado> servicios;


  private RepositorioServicioContratado() {
    this.servicios = new ArrayList<>();

  }

  public static RepositorioServicioContratado getServiciosContratados() {
    return instance;
  }

  public void agregarServicioContratado(ServicioContratado ser){
    this.servicios.add(ser);
  }
}
