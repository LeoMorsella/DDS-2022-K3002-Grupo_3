package APIMedicionesTests;

import HuellaDeCarbono.CalculoDeDistancias.APITokenGenerator;
import HuellaDeCarbono.CargaDeMediciones.CargaDeMediciones;
import HuellaDeCarbono.Organizacion.Medicion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class PruebaLecturaArchivo {
    @Test
    public void testCargarDatosALista() throws Exception {
        String filePath = "..\\DDS-2022-K3002-Grupo_3\\MedicionesOrganizacion.xlsx";
        CargaDeMediciones cargaMediciones = new CargaDeMediciones();
        cargaMediciones.useExistingWorkbook(filePath);
        List<Medicion> ListaMedicion = cargaMediciones.lecturaArchivo2(0);
        System.out.println(ListaMedicion.get(2).getValor());
    }


}





