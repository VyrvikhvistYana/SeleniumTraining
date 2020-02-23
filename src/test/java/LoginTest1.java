import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest1 {


        private WebDriver driver;
        private WebDriverWait wait;
        @Before
        public void start(){
            System.setProperty("webdriver.gecko.driver", "\\Downloads\\geckodriver.exe");
            driver=new FirefoxDriver();
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

