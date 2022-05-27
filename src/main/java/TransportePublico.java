import java.util.ArrayList;

public class TransportePublico extends Medio{
    public TipoTransportePublico tipoTransportePublico;
    public String linea;
    public ArrayList<Parada> paradas;

    public TransportePublico(TipoTransportePublico tipo, String linea, ArrayList<Parada> list){
        this.tipoTransportePublico = tipo;
        this.linea = linea;
        this.paradas = list;
    }

}
