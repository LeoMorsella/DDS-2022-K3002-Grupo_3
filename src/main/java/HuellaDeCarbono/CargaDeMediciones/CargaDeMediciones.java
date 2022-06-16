package HuellaDeCarbono.CargaDeMediciones;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.Iterator;

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

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    Iterator<Cell> cellIterator = row.cellIterator();
                    actividad = null;
                    tipoDeConsumo = null;
                    valor = 0;
                    periodicidad = null;
                    periodoImputacion = null;
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getCellType()) {
                            case NUMERIC:
                                valor = cell.getNumericCellValue();
                                break;

                            case STRING:
                                int numeroCelda = cell.getColumnIndex();
                                switch (numeroCelda) {

                                    case 0:
                                        actividad = cell.getStringCellValue();
                                        break;
                                    case 1:
                                        tipoDeConsumo = cell.getStringCellValue();
                                        break;
                                    case 2:
                                        valor = cell.getNumericCellValue();
                                        break;
                                    case 3:
                                        periodicidad = cell.getStringCellValue();
                                        break;
                                    case 4:
                                        periodoImputacion = cell.getStringCellValue();
                                        break;
                                }
                                break;


                        }

                    }
                    Medicion nuevaMedicion = new Medicion(actividad, tipoDeConsumo,valor, periodicidad, periodoImputacion);

                }
                System.out.println("RowDatoActividad{" +
                        "actividad='" + actividad + '\'' +
                        ", tipoDeConsumo='" + tipoDeConsumo + '\'' +
                        ", valor=" + valor + '\'' +
                        ", periodicidad='" + periodicidad +  '\'' +
                        ", periodoImputacion='" + periodoImputacion + '\'' +
                        '}');
            }catch (Exception e){
                e.printStackTrace();
            }

            return null;
        }
    }


