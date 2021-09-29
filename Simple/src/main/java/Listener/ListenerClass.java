package Listener;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListenerClass implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<>();
        List<Map<String, String>> list = new ArrayList<>();
        try {
            DataFormatter format = new DataFormatter();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/datas/Testdata_new.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet excelSheet = wb.getSheet("RunManager");

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
        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("TestCaseID"))) {

                    int index = methods.indexOf(methods.get(i));

                    /*methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                    methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("invocationCount")));*/

                    if (list.get(j).containsValue("N")) { //if execute column is TRUE/FALSE or YES/NO
                    } else {
                        result.add(methods.get(index));
                    }
                }
            }
        }
        return result;
    }
}
