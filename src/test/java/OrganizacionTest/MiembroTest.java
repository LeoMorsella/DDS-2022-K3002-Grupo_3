package OrganizacionTest;

import HuellaDeCarbono.CargaDeMediciones.DatoDeMedicion;
import HuellaDeCarbono.Movilidad.Recorrido;
import HuellaDeCarbono.ManejoAmbiental.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MiembroTest {
    @Test

    public void agregarAreaCorrectamente() {
        Ubicacion ubicacion = new Ubicacion("Argentina","Buenos Aires","La Matanza","Gonzalez Catan","Matienzo","15500");
        ArrayList<Area> areasPrueba = new ArrayList<>();
        Organizacion organizacionPrueba = new Organizacion("SA", TipoOrg.EMPRESA,ubicacion,areasPrueba,Clasificacion.MINISTERIO, null, null);
        ArrayList<Recorrido> recorrido = new ArrayList<>();
        Miembro miembro = new Miembro("Juan","Perez","DNI",123456789,areasPrueba,recorrido);
        ArrayList<Miembro> miembrosPrueba = new ArrayList<>();
        miembrosPrueba.add(miembro);
        Area areaPrueba = new Area("AreaPrueba",miembrosPrueba,organizacionPrueba);
        miembro.registrarseA(areaPrueba);
        Assertions.assertEquals(1,miembro.getAreas().size());

    }

    @Test
    public void medirImpactoPersonal() throws Exception {
        Ubicacion ubicacion = new Ubicacion("Argentina","Buenos Aires","La Matanza","Gonzalez Catan","Matienzo","15500");
        ArrayList<Area> areasPrueba = new ArrayList<>();
        Organizacion organizacionPrueba = new Organizacion("SA", TipoOrg.EMPRESA,ubicacion,areasPrueba,Clasificacion.MINISTERIO, null, null);
        ArrayList<Recorrido> recorrido = new ArrayList<>();
        Miembro miembro = new Miembro("Juan","Perez","DNI",123456789,areasPrueba,recorrido);
        DatoDeMedicion datoDeMedicion = new DatoDeMedicion("Electricidad adquirida y consumida","m3","Electricidad","2000","Diaria","30");
        ArrayList<DatoDeMedicion> mediciones = new ArrayList<>();
        mediciones.add(datoDeMedicion);
        // miembro.setMediciones(medicion); // TODO el miembro tiene mediciones?
        Assertions.assertEquals(2000,miembro.calcularImpactoIndividual(organizacionPrueba));
    }
}
