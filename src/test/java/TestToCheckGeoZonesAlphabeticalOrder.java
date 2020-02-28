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
        driver.findElement(By.linkText("Canada")).click();

        List<WebElement> listCanada = driver.findElements(By.xpath("//tr//td[3]//select[contains(@name, 'zone_code')]//option[@selected='selected']"));
        List<String> geoZonesCanada = new ArrayList<String>();
        for (WebElement e : listCanada) {
            geoZonesCanada.add(e.getAttribute("textContent"));
        }

        boolean sortedCanada = Ordering.natural().isOrdered(geoZonesCanada);
        System.out.println(sortedCanada);

        driver.navigate().back();
        driver.findElement(By.linkText("United States of America")).click();


        List<WebElement> listUSA = driver.findElements(By.xpath("//tr//td[3]//select[contains(@name, 'zone_code')]//option[@selected='selected']"));
        List<String> geoZonesUSA = new ArrayList<String>();
        for (WebElement e : listUSA) {
            geoZonesUSA.add(e.getAttribute("textContent"));
        }

        boolean sortedUSA = Ordering.natural().isOrdered(geoZonesUSA);
        System.out.println(sortedUSA);


    }
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
