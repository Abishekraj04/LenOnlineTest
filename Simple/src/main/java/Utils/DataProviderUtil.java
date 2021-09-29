package Utils;



import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.*;

public class DataProviderUtil {
    @DataProvider(name = "testdata")
    public static Object[][] getTestData(Method m)
    {
        String testname = m.getName();
        List<Map<String,String>> list = ExcelRead.readExcel("RunManager");
        List<Map<String,String>> slist = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).get("TestCaseID").equalsIgnoreCase(testname))
            {
                if(list.get(i).get("Execution").contains("Y"))
                {
                    slist.add(list.get(i));
                }
            }
        }

return new Object[][]{slist.toArray()};
    }
}
