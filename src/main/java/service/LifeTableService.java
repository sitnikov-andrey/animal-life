package service;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;

public class LifeTableService {
    public static Integer getChanceToEat(String firs, String second) {
        String chanceToEatXlsPath = "src/main/resources/chanceToEat.xls";
        Workbook workbook = null;

        try {
            workbook = Workbook.getWorkbook(new File(chanceToEatXlsPath));
            Sheet sheet = workbook.getSheet(0);

            int indexRow = 1;
            int indexColumn = 1;

            while (true) {
                Cell cell = sheet.getCell(indexColumn, 0);
                if (cell.getContents().equals(second)) {
                    break;
                }
                indexColumn++;
            }

            while (true) {
                Cell cell = sheet.getCell(0, indexRow);
                if (cell.getContents().equals(firs)) {
                    break;
                }
                indexRow++;
            }

            Cell cell = sheet.getCell(indexColumn, indexRow);
            return Integer.parseInt(cell.getContents());

        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                throw new Exception("Такого вида нет в таблице!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }

        return 0;
    }

    public static Integer animalsMaxCountInIsland(String sameLife) {
        String animalsMaxCountInIslandXlsPath = "src/main/resources/animalsMaxCountInIsland.xls";
        Workbook workbook = null;

        try {
            workbook = Workbook.getWorkbook(new File(animalsMaxCountInIslandXlsPath));
            Sheet sheet = workbook.getSheet(0);

            int indexRow = 0;
            int indexColumn = 1;

            while (true) {
                Cell cell = sheet.getCell(0, indexRow);
                if (cell.getContents().equals(sameLife)) {
                    break;
                }
                indexRow++;
            }

            Cell cell = sheet.getCell(indexColumn, indexRow);
            return Integer.parseInt(cell.getContents());

        } catch (ArrayIndexOutOfBoundsException e) {
            try {
                throw new Exception("Такого вида нет в таблице!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                workbook.close();
            }
        }

        return null;
    }
}
