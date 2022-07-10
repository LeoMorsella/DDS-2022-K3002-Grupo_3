package HuellaDeCarbono.CalculoDeHuella;

import HuellaDeCarbono.ManejoAmbiental.Miembro;
import HuellaDeCarbono.Movilidad.Recorrido;
import HuellaDeCarbono.Movilidad.Trayecto;

public class CalcularHuellaDeCarbonoMiembro {

    public static Double calcularHCMiembro(Miembro miembro) throws Exception {
        Double HC = 0.0;
        for(Recorrido recorrido : miembro.getRecorridos()) {
            HC += calcularHCRecorrido(recorrido);
        }
        //Se multiplica por 20 para generar el impacto de un mes
        return HC * 20;
    }

    private static Double calcularHCRecorrido (Recorrido recorrido) throws Exception {
        Double HC = 0.0;
        for(Trayecto trayecto : recorrido.getTrayectos()) {
            HC += calcularHCTrayecto(trayecto) * recorrido.getFactorDeUso();
        }
        return HC;
    }

    public static Double calcularHCTrayecto(Trayecto trayecto) throws Exception {
        return trayecto.distanciaMedia() * FactoresDeEmision.getFactores().getFE(trayecto.getMedioTransporte().getTipo());
    }

}
