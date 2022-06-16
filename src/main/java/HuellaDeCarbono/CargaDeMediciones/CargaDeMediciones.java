package HuellaDeCarbono.CargaDeMediciones;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Lectura de archivo Excel usando Api Apache Poi
    public class CargaDeMediciones {

        private FileInputStream file;
        private XSSFWorkbook workbook;
        private XSSFSheet sheet;
        private String xlFilePath;

        public CargaDeMediciones(){
            //Do nothing
        }

        public CargaDeMediciones useExistingWorkbook(String filePath) {

            try {
                this.xlFilePath = filePath;
                file = new FileInputStream(xlFilePath);
                workbook = new XSSFWorkbook(file);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return this;
        }

        public Object lecturaArchivo(int sheetNumber) {
            try {
                sheet = workbook.getSheetAt(sheetNumber); // Obtiene la hoja de la posicion 0 (Hoja 1) del archivo

                // Empieza a iterar entre filas y celdas
                Iterator<Row> rowIterator = sheet.iterator();
                rowIterator.next();
                rowIterator.next(); // Evita leer las dos primeras filas(Titulos)

                String actividad = null;
                String tipoDeConsumo = null;
                double valor = 0;
                String periodicidad = null;
                String periodoImputacion = null;

                List<Medicion> listaMediciones = new ArrayList<>();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Medicion nuevaMedicion = new Medicion(actividad, tipoDeConsumo, valor, periodicidad, periodoImputacion);

                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {

                        Cell cell = cellIterator.next();

                        int numeroCelda = cell.getColumnIndex();
                        switch (numeroCelda) {

                            case 1:
                                actividad = cell.getStringCellValue();
                                break;
                            case 2:
                                tipoDeConsumo = cell.getStringCellValue();
                                break;
                            case 3:
                                valor = cell.getNumericCellValue();
                            case 4:
                                periodicidad = cell.getStringCellValue();
                                break;
                            case 5:
                                periodoImputacion = cell.getStringCellValue();
                                break;
                            default:
                                //No hace nada porque el campo no es numerico
                                break;
                        }
                    }
                    listaMediciones.add(nuevaMedicion);
                }
                return listaMediciones;

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }


