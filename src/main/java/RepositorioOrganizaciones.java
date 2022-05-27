import java.util.ArrayList;
import java.util.List;

public class RepositorioOrganizaciones {
  private static RepositorioOrganizaciones instance = new RepositorioOrganizaciones();
  public List<Organizacion> organizaciones;


  private RepositorioOrganizaciones() {
    this.organizaciones = new ArrayList<>();

  }

  public static RepositorioOrganizaciones getRepositorio() {
    return instance;
  }

  public void agregarOrganizacion(Organizacion org){
    this.organizaciones.add(org);
  }
}
