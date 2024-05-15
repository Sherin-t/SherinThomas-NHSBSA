package BasePage;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseApp {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions Action;
	public static Connection con;
	public void start(String url, String path) {
		WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				DesiredCapabilities caps = new DesiredCapabilities();
				// Change resolution
				caps.setCapability("resolution", "1024x768");
				driver.manage().window().maximize();
				driver.get(url);
	}

	public void teardown() {
		driver.quit();
	}

	public String RandomEventName() {
		Faker a = new Faker();
		int b = a.number().numberBetween(100, 1000);
		String name = b + "Eventname";
		return name;

	}

	public String RandomMemberName() {
		Faker a = new Faker();
		String membername = a.name().firstName() + a.name().firstName();
		return membername;
	}

	public String[] futureMonthDateGenerate() throws ParseException {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MMM-dd");
		String current = date.format(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date.parse(current));
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		String futuredate = date.format(calendar.getTime());
		String nextdate[] = futuredate.split("-");
		return nextdate;
	}

	public String[] generateCurrentMonthdate() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MMM-dd");
		String current = date.format(d);
		String a[] = current.split("-");
		return a;
	}

	public static void deleteVideos(String path) {
		File directory = new File(path);
		File[] files = directory.listFiles();
		for (File file : files) {
			file.delete();
		}
	}

	public void refresh() {
		driver.navigate().refresh();

	}

	public void clearText(String xpath) {
		WebElement toClear = driver.findElement(By.xpath(xpath));
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);

	}

	public void SelectAll(String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
	}

	public String[] futureDateGenerate() throws ParseException {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd-MMM");
		String current = date.format(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date.parse(current));
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		String futuredate = date.format(calendar.getTime());
		String nextdate[] = futuredate.split("-");
		return nextdate;
	}

	public String[] futuresecondgameMonthDateGenerate() throws ParseException {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MMM-dd");
		String current = date.format(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date.parse(current));
		calendar.add(Calendar.DAY_OF_YEAR, 2);
		String futuredate = date.format(calendar.getTime());
		String nextdate[] = futuredate.split("-");
		return nextdate;
	}

	public String[] generateCurrentdateMonth() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd-MMM");
		String current = date.format(d);
		String a[] = current.split("-");
		return a;
	}

	public String getText(String xpath) {
		String elementvalue = null;
		try {
			String textvalue = driver.findElement(By.xpath(xpath)).getText();
			elementvalue = textvalue;
		} catch (Exception e) {

		}
		return elementvalue;

	}

	public void MouseClickToElement(String xpath) {
		Action = new Actions(driver);
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Action.moveToElement(element).click(element).build().perform();
		} catch (Exception e) {

		}
	}

	public void DoubleClickToElement(String xpath) {
		Action = new Actions(driver);
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Action.doubleClick(element).build().perform();
		} catch (Exception e) {

		}
	}

	public void MoveToElement(String xpath) {
		Action = new Actions(driver);
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Action.moveToElement(element).build().perform();
		} catch (Exception e) {

		}
	}

	public boolean isDisplayed(String xpath) {
		boolean flag;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = driver.findElement(By.xpath(xpath)).isDisplayed();
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public boolean FindByisDisplayed(WebElement xpath) {
		boolean flag;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = xpath.isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isDisplayedcss(String xpath) {
		boolean flag;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = driver.findElement(By.cssSelector(xpath)).isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean isEnabled(String xpath) {
		boolean flag;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = driver.findElement(By.xpath(xpath)).isEnabled();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public String getAttribute(String xpath, String attibute) {
		String flag = null;
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			flag = driver.findElement(By.xpath(xpath)).getAttribute(attibute);
		} catch (Exception e) {

		}
		return flag;
	}

	public boolean typeIn(String text, String data) {
		boolean flag;
		WebElement Send = driver.findElement(By.xpath(text));
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(Send));
			Send.clear();
			Send.sendKeys(data);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public String Currentdate() {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		String current = date.format(d);
		return current;

	}

	public String pastDate() {
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -2);
		String pastDate = date.format(cal.getTime());
		return pastDate;
	}

	public boolean click(String click) {
		boolean flag;
		WebElement select = driver.findElement(By.xpath(click));
		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(select));
			select.click();
			flag = true;
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public boolean Elementappear(String xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			flag = true;
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public boolean ElementappearCSS(String css) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
			flag = true;
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public boolean ElementdisappearCSS(String css) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 10);
			flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(css)));
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public boolean Elementdisappear(String xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 15);
			flag = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean Elementclickable(String xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			flag = true;
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public boolean Element(String xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			WebElement element = driver.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.stalenessOf(element));
			flag = true;
		} catch (Exception e) {

			flag = false;
		}
		return flag;
	}

	public String pickLatestFileFromDownloads() {
		String currentUsersHomeDir = System.getProperty("user.home");
		String downloadFolder = currentUsersHomeDir + File.separator + "Downloads" + File.separator;
		File dir = new File(downloadFolder);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			System.out.println("###-NO File are present In Download Folder-###");
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		String Location = lastModifiedFile.toString();
		return Location;
	}

	public String[] futureDateGenerate(int a) throws ParseException {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd-MMM");
		String current = date.format(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date.parse(current));
		calendar.add(Calendar.DAY_OF_YEAR, a);
		String futuredate = date.format(calendar.getTime());
		String nextdate[] = futuredate.split("-");
		return nextdate;

	}

	public String futureDateFormat(int noofdaysincount) throws ParseException {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy");
		String current = date.format(d);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date.parse(current));
		calendar.add(Calendar.DAY_OF_YEAR, noofdaysincount);
		String futuredate = date.format(calendar.getTime());
		return futuredate;
	}

	// FOR PAGE OBJECT MODEL PATTERN PASSING WEBELEMENTS DIRECTLY
	public boolean FindByclick(WebElement select) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(select));
			select.click();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean FindByElementappear(WebElement xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(xpath));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean FindByElementdisappear(WebElement xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOf(xpath));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public void MouseClickToElement(WebElement element) {
		Action = new Actions(driver);
		try {
			Action.moveToElement(element).click(element).build().perform();
		} catch (Exception e) {
		}
	}

	public void FindByMoveToElements(WebElement xpath) {
		Action = new Actions(driver);
		try {
			Action.moveToElement(xpath).build().perform();
		} catch (Exception e) {
		}
	}

	public boolean FindByElementClickable(WebElement xpath) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(xpath));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public boolean FindBytypeIn(WebElement Send, String data) {
		boolean flag;
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(Send));
			Send.clear();
			Send.sendKeys(data);
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;

	}

	public void FindByDoubleClickToElement(WebElement xpath) {
		Action = new Actions(driver);
		try {
			Action.doubleClick(xpath).build().perform();
		} catch (Exception e) {
		}
	}

	public void FidnByMoveToElement(WebElement element) {
		Action = new Actions(driver);
		try {

			Action.moveToElement(element).build().perform();
		} catch (Exception e) {
		}
	}

	public void takeScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String filePath = System.getProperty("user.dir") + "\\reports\\" + fileName;
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(filePath));
		ExtentCucumberAdapter.getCurrentStep().addScreenCaptureFromPath(filePath);
	}

	public static Connection connectToDatabase(String url, String uname, String pword) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, uname, pword);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("DB Connectivity Failed");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver not set successfully");
		}

		return con;

	}

	public void frame() {
		driver.switchTo().frame(0);

	}

	public void newtab() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
}