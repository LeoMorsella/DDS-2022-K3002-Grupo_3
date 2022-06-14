package OrganizacionTest;

import HuellaDeCarbono.Movilidad.Trayecto;
import HuellaDeCarbono.Organizacion.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

import java.util.ArrayList;

public class MiembroTest {
    @Test

    public void agregarAreaCorrectamente() {
        Ubicacion ubicacion = new Ubicacion("Buenos Aires","Gonzalez Catan","Matienzo","15400");
        ArrayList<Area> areasPrueba = new ArrayList<>();
        Organizacion organizacionPrueba = new Organizacion("SA", TipoOrg.EMPRESA,ubicacion,areasPrueba,Clasificacion.MINISTERIO);
        ArrayList<ArrayList<Trayecto>> recorrido = new ArrayList<>();
        Miembro miembro = new Miembro("Juan","Perez","DNI", Rol.MIEMBRO,123456789,areasPrueba,recorrido,"prueba","Yagni3210+");
        ArrayList<Miembro> miembrosPrueba = new ArrayList<>();
        miembrosPrueba.add(miembro);
        Area areaPrueba = new Area("AreaPrueba",miembrosPrueba,organizacionPrueba);
        miembro.registrarseA(areaPrueba);
        Assertions.assertEquals(1,miembro.areas.size());

    }
}
