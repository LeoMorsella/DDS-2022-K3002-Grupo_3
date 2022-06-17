package HuellaDeCarbono.Repositorios;

import HuellaDeCarbono.MedioDeTransporte.TransportePublico;

import java.util.ArrayList;
import java.util.List;
public class RepositorioTransportesPublicos {
  private static RepositorioTransportesPublicos instance = new RepositorioTransportesPublicos();
  private List<TransportePublico> lineas;


  private RepositorioTransportesPublicos() {
    this.lineas = new ArrayList<>();

  }

  public List<TransportePublico> getLineas() {
    return lineas;
  }

  public void setLineas(List<TransportePublico> lineas) {
    this.lineas = lineas;
  }

  public static RepositorioTransportesPublicos getRepositorio() {
    return instance;
  }

  public void agregarLinea(TransportePublico tra){
    this.lineas.add(tra);
  }
}
