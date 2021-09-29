package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class readDataFromExcel {
    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method
public static void main(String[] args) throws Exception {
    excelDataProvider();

}
    public static  Object[][] excelDataProvider() throws IOException, IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/datas/Testdata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("RunManager");
        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] dataObject = new Object[rowCount][1];
        for (int row = 0; row < rowCount; row++) {
            HashMap<String, String> data = new HashMap<>();
            for (int col = 0; col < columnCount; col++) {
                String key = sheet.getRow(0).getCell(col).getStringCellValue();
                String value = sheet.getRow(row + 1).getCell(col).getStringCellValue();
                data.put(key, value);
            }
            dataObject[row][0] = data;
        }
        workbook.close();
        return dataObject;
    }
}