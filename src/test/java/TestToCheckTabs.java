import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class TestToCheckTabs {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, 5);
    }


    @Test
    public void myTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Afghanistan"))).click();
        List<WebElement> listOfLinkstoTabs=driver.findElements(By.cssSelector("td#content td a[target='_blank']"));
        for(int i=0; i<listOfLinkstoTabs.size(); i++){
            listOfLinkstoTabs=driver.findElements(By.cssSelector("td#content td a[target='_blank']"));

            String window=driver.getWindowHandle();

            final Set<String> oldWindows=driver.getWindowHandles();
            listOfLinkstoTabs.get(i).click();


            String newWindow = (new WebDriverWait(driver, 10))
                    .until(new ExpectedCondition<String>() {
                               public String apply(WebDriver driver) {
                                   Set<String> newWindowsSet = driver.getWindowHandles();
                                   newWindowsSet.removeAll(oldWindows);
                                   return newWindowsSet.size() > 0 ?
                                           newWindowsSet.iterator().next() : null;
                               }
                           }
                    );

            driver.switchTo().window(newWindow);

            System.out.println("New window title: " + driver.getTitle());
            driver.close();

            driver.switchTo().window(window);
            System.out.println("Old window title: " + driver.getTitle());
           

        }
    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }

}
