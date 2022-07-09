package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.ManejoAmbiental.Miembro;
import HuellaDeCarbono.ManejoAmbiental.Organizacion;

import java.util.ArrayList;
    import java.util.List;

public class RepositorioMiembros {
  private static RepositorioMiembros instance = new RepositorioMiembros();
  private List<Miembro> miembros;


  private RepositorioMiembros() {
    this.miembros = new ArrayList<>();
  }

  public List<Miembro> getMiembros() {
    return miembros;
  }

  public void setMiembros(List<Miembro> miembros) {
    this.miembros = miembros;
  }

  public static RepositorioMiembros getRepositorio() {
    return instance;
  }

  public void agregarMiembro(Miembro miem){
    this.miembros.add(miem);
  }
}