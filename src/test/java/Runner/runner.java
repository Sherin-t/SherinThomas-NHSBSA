package Runner;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import BasePage.BaseApp;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "./src/test/java/Features", glue = "StepDefinition", plugin = {
        "html:target/cucumber-html-report", "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "rerun:target/failedrerun.txt" }, strict = true, monochrome = true, tags = "@SmokeTest")

public class runner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void start() throws Exception {
        BaseApp KickStart = new BaseApp();
        Properties props = new Properties();
        String projectpath = System.getProperty("user.dir");
        FileInputStream file = new FileInputStream(projectpath + "\\Environment.properties");
        props.load(file);
        KickStart.start(props.getProperty("URL"), projectpath);
    }

    @AfterSuite
    public void teardown() throws InterruptedException {
        BaseApp Breakout = new BaseApp();
        Breakout.teardown();

    }
}
