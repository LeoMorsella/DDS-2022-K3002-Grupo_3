package HuellaDeCarbono.MedioDeTransporte;

import HuellaDeCarbono.MedioDeTransporte.Medio;
import HuellaDeCarbono.MedioDeTransporte.Parada;
import HuellaDeCarbono.MedioDeTransporte.TipoTransportePublico;

import java.util.ArrayList;

public class TransportePublico extends Medio {
    public TipoTransportePublico tipoTransportePublico;
    public String linea;
    public ArrayList<Parada> paradas;

    public TransportePublico(TipoTransportePublico tipo, String linea, ArrayList<Parada> list){
        this.tipoTransportePublico = tipo;
        this.linea = linea;
        this.paradas = list;
    }

    public TipoTransportePublico getTipoTransportePublico() {
        return tipoTransportePublico;
    }

    public void setTipoTransportePublico(TipoTransportePublico tipoTransportePublico) {
        this.tipoTransportePublico = tipoTransportePublico;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public ArrayList<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(ArrayList<Parada> paradas) {
        this.paradas = paradas;
    }
}
