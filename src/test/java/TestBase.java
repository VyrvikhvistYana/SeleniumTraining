import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class TestBase {
    public static ThreadLocal<EventFiringWebDriver> tlDriver=new ThreadLocal<>();
    public EventFiringWebDriver driver;

    public WebDriverWait wait;
public Proxy proxy;

public static class MyListener extends AbstractWebDriverEventListener{
        @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver){
            System.out.println(by);
        }
        @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver){
            System.out.println(by +"found");
        }

        @Override
    public void onException(Throwable throwable, WebDriver driver){
            System.out.println(throwable);
            File tmp=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        }
}

    @Before
    public void start(){
    if(tlDriver.get()!=null){
        driver=tlDriver.get();
        wait=new WebDriverWait(driver, 5);
        return;
    }

       proxy = new BrowserMobProxy();
        proxy.start(0);


        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

    driver =new EventFiringWebDriver(new ChromeDriver(capabilities));
    driver.register(new MyListener());
    tlDriver.set(driver);
    wait= new WebDriverWait(driver, 10);

        //Runtime.getRuntime().addShutdownHook(
                //new Thread(() -> (driver.quit(); driver=null;)

        //System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        //driver=new ChromeDriver();


    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}

