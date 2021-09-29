package Utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.IMethodInstance;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelRead {

  /*  public static void main(String[] args) {
        //readExcel();
    }*/

    public static List<Map<String, String>> readExcel(String sheetname) {
        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String, String>> list = new ArrayList<>();

        try {
            DataFormatter format = new DataFormatter();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/datas/Testdata_new.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet excelSheet = wb.getSheet(sheetname);

            Map<String, String> map;

            for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                map = new HashMap<>();
                for (int col = 0; col < excelSheet.getRow(row).getLastCellNum(); col++) {
                    String key = format.formatCellValue(excelSheet.getRow(0).getCell(col));
                    String value = format.formatCellValue(excelSheet.getRow(row).getCell(col));
                    map.put(key, value);
                }
                list.add(map);
                System.out.println(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    }
