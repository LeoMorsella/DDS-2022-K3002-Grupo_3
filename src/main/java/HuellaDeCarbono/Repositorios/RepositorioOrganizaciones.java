package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.ManejoAmbiental.Organizacion;

import java.util.ArrayList;
import java.util.List;

public class RepositorioOrganizaciones {
  private static RepositorioOrganizaciones instance = new RepositorioOrganizaciones();
  private List<Organizacion> organizaciones;


  private RepositorioOrganizaciones() {
    this.organizaciones = new ArrayList<>();

  }

  public List<Organizacion> getOrganizaciones() {
    return organizaciones;
  }

  public void setOrganizaciones(List<Organizacion> organizaciones) {
    this.organizaciones = organizaciones;
  }

  public static RepositorioOrganizaciones getRepositorio() {
    return instance;
  }

  public void agregarOrganizacion(Organizacion org){
    this.organizaciones.add(org);
  }
}
