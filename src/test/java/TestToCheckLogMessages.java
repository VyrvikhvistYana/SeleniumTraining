import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;

public class TestToCheckLogMessages {

    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){


        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, 5);
        //DesiredCapabilities caps=DesiredCapabilities.chrome();
        //LoggingPreferences logPrefs = new LoggingPreferences();
        //logPrefs.enable(LogType.BROWSER, Level.ALL);
        //caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        //driver = new ChromeDriver(caps);
    }

    @Test
    public void myTest() {
        driver.get("http://localhost/litecart/admin/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Rubber Ducks")).click();

        List<WebElement> listOfItemsInCatalog =driver.findElements(By.cssSelector("a[href*='product_id']:not([title='Edit'])"));
        for (int i=0; i<listOfItemsInCatalog.size();i++){
            listOfItemsInCatalog=driver.findElements(By.cssSelector("a[href*='product_id']:not([title='Edit'])"));
            listOfItemsInCatalog.get(i).click();
            analyzeLog();
            driver.navigate().back();
        }
    }

   public void analyzeLog() {

       LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
       if(logEntries.getAll().size()>0){
           System.out.println("Browser logs are detected");
       }
       for (LogEntry entry : logEntries) { System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
       }
    }
    @After
    public void stop(){
    driver.quit();
    //driver=null;
    }
}
