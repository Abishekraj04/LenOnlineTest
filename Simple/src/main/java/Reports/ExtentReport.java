/*
package Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExtentReport {
public ExtentReports extent = new ExtentReports();
public ExtentSparkReporter spark ;
public ExtentTest test;
public void setUpReport()
{

    spark = new ExtentSparkReporter("index.html");
    extent.attachReporter(spark);
    spark.config().setTheme(Theme.STANDARD);
    spark.config().setDocumentTitle("AutomationReport");
    spark.config().setReportName("Test");
}
public void createTest(String testcasename)
{

   test = extent.createTest(testcasename);
   test.pass("Testcase passed");
}

public void tearDownReport() throws IOException {
    extent.flush();
  //  Desktop.getDesktop().browse(new File("index.html").toURI());
}

}
*/
