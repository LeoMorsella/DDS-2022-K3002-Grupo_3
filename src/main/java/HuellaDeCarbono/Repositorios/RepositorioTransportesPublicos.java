package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.TransportePublico;

import java.util.ArrayList;
import java.util.List;
public class RepositorioTransportesPublicos {
  private static RepositorioTransportesPublicos instance = new RepositorioTransportesPublicos();
  public List<TransportePublico> lineas;


  private RepositorioTransportesPublicos() {
    this.lineas = new ArrayList<>();

  }

  public static RepositorioTransportesPublicos getTransportesPublicos() {
    return instance;
  }

  public void agregarLinea(TransportePublico tra){
    this.lineas.add(tra);
  }
}
