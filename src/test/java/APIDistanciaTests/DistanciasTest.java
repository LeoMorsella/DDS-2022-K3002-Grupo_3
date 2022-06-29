package APIDistanciaTests;

import HuellaDeCarbono.MedioDeTransporte.MedioMotorizado;
import HuellaDeCarbono.MedioDeTransporte.MedioNoMotorizado;
import HuellaDeCarbono.Movilidad.Recorrido;
import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.ManejoAmbiental.Ubicacion;
import org.junit.Test;

import java.util.ArrayList;

public class DistanciasTest {

    @Test
    public void testDevuelveDistancia() throws Exception {
        Ubicacion ubicacion1Inic = new Ubicacion("ARGENTINA", "MISIONES",
                "MONTECARLO", "CARAGUATAY ", "maipu", "100");
        Ubicacion ubicacion1Final = new Ubicacion("ARGENTINA", "MISIONES",
                "MONTECARLO", "CARAGUATAY ", "maipu", "200");
        Ubicacion ubicacion2Inic = new Ubicacion("ARGENTINA", "MISIONES",
                "MONTECARLO", "CARAGUATAY ", "maipu", "300");
        Ubicacion ubicacion2Final = new Ubicacion("ARGENTINA", "MISIONES",
                "MONTECARLO", "CARAGUATAY ", "maipu", "400");
        Recorrido recorridoPrueba = new Recorrido();
        Trayecto trayectoPrueba1 = Trayecto.getTrayecto(ubicacion1Inic, ubicacion1Inic, new MedioMotorizado());
        Trayecto trayectoPrueba2 = Trayecto.getTrayecto(ubicacion2Inic, ubicacion2Final, new MedioNoMotorizado());

        ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();
        trayectos.add(trayectoPrueba1);
        trayectos.add(trayectoPrueba2);

        recorridoPrueba.addTrayectos(trayectos);
        System.out.println(trayectoPrueba1.distanciaMedia());
        System.out.println(trayectoPrueba2.distanciaMedia());

        System.out.println(recorridoPrueba.distanciaTotal());

    }

}
