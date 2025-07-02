package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;

 //  <-- make sure this is your BaseClass’ real package

/**
 * Generates a Spark (HTML) report for every TestNG run.
 */
public class ExtentReportManager implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports       extent;
    private ExtentTest          test;

    private String repName;   // report-file name (set in onStart)

    /* -----------------------  TestNG listener hooks  ----------------------- */

    @Override
    public void onStart(ITestContext testContext) {

        // ----- reporter path & appearance -----
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName          = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "\\reports\\" + repName);

        sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
        sparkReporter.config().setReportName  ("OpenCart Functional Testing");
        sparkReporter.config().setTheme       (Theme.DARK);

        // ----- Extent object & common meta data -----
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module",      "Admin");
        extent.setSystemInfo("Sub-Module",  "Customers");
        extent.setSystemInfo("User Name",   System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        // data passed via <suite> / <test> parameters in testng.xml
        String os      = testContext.getCurrentXmlTest().getParameter("os");
        String browser = testContext.getCurrentXmlTest().getParameter("browser");

        if (os      != null) extent.setSystemInfo("Operating System", os);
        if (browser != null) extent.setSystemInfo("Browser", browser);

        List<String> groups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (groups != null && !groups.isEmpty())
            extent.setSystemInfo("Groups", groups.toString());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " executed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " failed");
        test.log(Status.INFO, result.getThrowable());

        /* ----- screenshot on failure ----- */
        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " skipped");
        test.log(Status.INFO, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();   // write everything to disk

        /* Open the freshly-generated report in the default browser */
        File reportFile = new File(System.getProperty("user.dir") + "\\reports\\" + repName);
        try {
            Desktop.getDesktop().browse(reportFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* ---- (other ITestListener methods can be overridden if required) ---- */
}

