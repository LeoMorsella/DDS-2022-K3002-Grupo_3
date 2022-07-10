package HuellaDeCarbono.CalculoDeHuella;


import HuellaDeCarbono.CargaDeMediciones.DatoDeActividad;
import HuellaDeCarbono.ManejoAmbiental.Miembro;

import java.util.List;

public class CalcularHuellaDeCarbono {

    Double k = 0.0;
    private static CalcularHuellaDeCarbono instance = new CalcularHuellaDeCarbono();

    public Double getK() {
        return k;
    }

    public static CalcularHuellaDeCarbono getCalculadora() {
        return instance;
      }

    public void setK(Double k) {
        this.k = k;
    }

    /* public CalcularHuellaDeCarbono(Double k) {
        this.k = k;
    } */

    public CalcularHuellaDeCarbono(){
        this.k = 0.0;
    }

    //Todos los calculos de HC se hacen respecto a un mes de consumo
    public Double calcularHCMedicion(List<DatoDeActividad> medicion) {
        return CalcularHuellaDeCarbonoMedicion.calcularHCMedicion(medicion, k);
    }

    public Double calcularHCMiembro(Miembro miembro) throws Exception {
        return CalcularHuellaDeCarbonoMiembro.calcularHCMiembro(miembro);
    }
}
