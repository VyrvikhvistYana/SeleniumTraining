import com.google.common.collect.Ordering;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TestToCheckGeoZonesAlphabeticalOrder {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, 10);
    }
    @Test
    public void myTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.linkText("Geo Zones")).click();

        List<WebElement> listOfCountries=driver.findElements(By.cssSelector("a[title='Edit']"));
    for(int i=0; i<listOfCountries.size(); i++)
{       listOfCountries=driver.findElements(By.cssSelector("a[title='Edit']"));
        System.out.println(listOfCountries.size());
        listOfCountries.get(i).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//tr//td[3]//select[contains(@name, 'zone_code')]//option[@selected='selected']")));
        List<WebElement> listOfZones = driver.findElements(By.xpath("//tr//td[3]//select[contains(@name, 'zone_code')]//option[@selected='selected']"));
        List<String> geoZones = new ArrayList<String>();
        for (WebElement e : listOfZones) {
            geoZones.add(e.getAttribute("textContent"));
        }
        boolean sorted = Ordering.natural().isOrdered(geoZones);
        System.out.println(sorted);
        driver.navigate().back();}
    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
