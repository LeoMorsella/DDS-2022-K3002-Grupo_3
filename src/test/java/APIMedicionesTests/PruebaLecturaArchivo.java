package APIMedicionesTests;

import HuellaDeCarbono.CalculoDeDistancias.Pais;
import HuellaDeCarbono.CalculoDeDistancias.Provincia;
import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.CargaDeMediciones.DatoDeMedicion;
import HuellaDeCarbono.ManejoAmbiental.*;
import HuellaDeCarbono.MedioDeTransporte.*;
import HuellaDeCarbono.Movilidad.Recorrido;
import HuellaDeCarbono.Movilidad.Trayecto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PruebaLecturaArchivo {
    ArrayList<Area> areas = new ArrayList<Area>();
    ArrayList<Miembro> contactos = new ArrayList<Miembro>();
    ArrayList<Miembro> miembros = new ArrayList<Miembro>();

    Ubicacion ubicacion1 = new Ubicacion("ARGENTINA", "MISIONES", "MONTECARLO", "CARAGUATAY ", "maipu", "100");
    Ubicacion ubicacion2 = new Ubicacion("ARGENTINA", "MISIONES", "MONTECARLO", "CARAGUATAY ", "maipu", "200");
    Ubicacion ubicacion3 = new Ubicacion("ARGENTINA", "MISIONES", "MONTECARLO", "CARAGUATAY ", "maipu", "300");


    Trayecto trayecto1 = new Trayecto(ubicacion1,ubicacion2, new MedioMotorizado());
    Trayecto trayecto2 = new Trayecto(ubicacion2,ubicacion3, new MedioNoMotorizado());
    ArrayList<Trayecto> trayectos = new ArrayList<Trayecto>();

    Recorrido recorrido = new Recorrido(trayectos);

    Organizacion organizacion = new Organizacion("", TipoOrg.GUBERNAMENTAL,ubicacion3,areas,Clasificacion.MINISTERIO,contactos,contactos);
    Area area = new Area("",miembros,organizacion);

    ArrayList<Recorrido> recorridos = new ArrayList<>();

    Miembro miembro = new Miembro("algo","","",12345, areas, recorridos);

    @Test
    public void testCargarDatosALista() {
        String filePath = "..\\DDS-2022-K3002-Grupo_3\\mediciones1.xlsx";
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        List<DatoDeMedicion> listaDatoDeMedicion = cargaMediciones.lecturaArchivo(0);
        System.out.println(listaDatoDeMedicion.get(2).getValor());
        //Assert.assertEquals(listaDatoDeMedicion.get(2).getValor());
    }

    @Test
    public void calcularHuellaMiembro() {
        trayectos.add(trayecto1);
        trayectos.add(trayecto2);
        areas.add(area);
        recorridos.add(recorrido);
        miembros.add(miembro);

        Double huella = miembro.calcularHC();

        Assert.assertEquals(Optional.of(1.1),huella);
    }

    @Test
    public void calcularHuellaOrganizacion() throws Exception {
        trayectos.add(trayecto1);
        trayectos.add(trayecto2);
        areas.add(area);
        recorridos.add(recorrido);
        miembros.add(miembro);

        Double huella = organizacion.calcularHC();

        Assert.assertEquals(Optional.of(1.1),huella);
    }

    @Test
    public void calcularHuellaArea() throws Exception {
        trayectos.add(trayecto1);
        trayectos.add(trayecto2);
        areas.add(area);
        recorridos.add(recorrido);
        miembros.add(miembro);

        Double huella = area.calcularHC();

        Assert.assertEquals(Optional.of(1.1),huella);
    }
}










