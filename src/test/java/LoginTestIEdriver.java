import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestIEdriver {


    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
       System.setProperty("webdriver.ie.driver", "\\Downloads\\IEDriverServer.exe");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true );
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(caps);
        //driver=new InternetExplorerDriver();
        wait=new WebDriverWait(driver, 10);
    }
    @Test
    public void myTest(){
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}

