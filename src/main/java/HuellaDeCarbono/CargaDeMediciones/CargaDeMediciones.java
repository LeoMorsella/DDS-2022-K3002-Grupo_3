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

        public void lecturaArchivo(int sheetNumber) {
            try {
                sheet = workbook.getSheetAt(sheetNumber); // Obtiene la hoja de la posicion 0 (Hoja 1) del archivo

                // Empieza a iterar entre filas y celdas
                Iterator<Row> rowIterator = sheet.iterator();
                rowIterator.next();
                rowIterator.next(); // Evita leer las dos primeras filas(Titulos)

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();

                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getCellType()) {
                            case NUMERIC:
                                System.out.println(cell.getNumericCellValue() + "\t");
                                break;

                            case STRING:
                                System.out.println(cell.getStringCellValue() + "\t");
                                break;
                        }
                    }


                    System.out.println("");
                }
                file.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }


