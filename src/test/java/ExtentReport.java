//Extent report is one of the well known industrial report where you can set name of each and every test case and visual represention of the extent report is very good.
//For extent report we need to import one of the maven repo name is extent report or if you won't get in maven repo then search on google
// For extent report we will have to use 2 of the class 1) ExtentReports 2) ExtentSparkReporter
//Among them, ExtentSparkReporter class is used to create skeleton of the report and ExtentReports is use for apply that skeleton

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class ExtentReport {
    public static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        String Path= System.getProperty("user.dir")+"\\reports\\index.html"; //Here I am setting up path for my report System.getProperty("user.dir") means aa test run bija koy system ma run thase to aa system no by default j path hase aa  automatic lay leshe for example c:/system/admin/nikunj
        ExtentSparkReporter extentSparkReporter=new ExtentSparkReporter(Path);
        //Here I prepared skeleton of the report by setting up report and document title
        extentSparkReporter.config().setReportName("Demo for NopCommerce");
        extentSparkReporter.config().setDocumentTitle("Test for Open Website");

        ExtentReports extentReport=new ExtentReports();
        extentReport.attachReporter(extentSparkReporter); //Here I am passing object of ExtentSparkReport so ExtentReport can know skeleton of the report
        extentReport.setSystemInfo("OpenWebsite", "Nikunj Maniya");

        extentReport.createTest("Login Scenario"); //When you write this line from where you extent report will start to generate

        Assert.assertEquals("Welcome to our store", "Welcome to our store");
        driver.findElement(By.cssSelector(".ico-login")).click();
        driver.findElement(By.cssSelector(".email")).sendKeys("admin@gmail.com");
        driver.findElement(By.className("password")).sendKeys("Admin@123");
        driver.findElement(By.className("login-button")).click();

        extentReport.flush(); //Here flush function means extent report generation will stop
    }

}
