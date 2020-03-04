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

public class TestToCheckAlphabeticalOrder {
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
        driver.findElement(By.linkText("Countries")).click();


        List<WebElement> links = driver.findElements(By.cssSelector(".dataTable tbody .row td:nth-child(5)"));
        List<String> namesOfCountries = new ArrayList<String>();
        for (WebElement e : links) {
            namesOfCountries.add(e.getAttribute("textContent"));
        }
        boolean sorted = Ordering.natural().isOrdered(namesOfCountries);
        System.out.println(sorted);

        List<WebElement> listOfQuantityOfZones=driver.findElements(By.cssSelector(".dataTable tbody .row td:nth-child(6)"));

        for(int i=0; i<listOfQuantityOfZones.size();i++){
            List<WebElement> listOfLinksToEdit=driver.findElements(By.cssSelector("a[title='Edit']"));
            listOfQuantityOfZones=driver.findElements(By.cssSelector(".dataTable tbody .row td:nth-child(6)"));
            if(Integer.parseInt(listOfQuantityOfZones.get(i).getText())>0){
                listOfLinksToEdit.get(i).click();
                List<WebElement> listOfZonesOfCountry=driver.findElements(By.cssSelector("table#table-zones td:nth-child(3) input[type='hidden']"));
                List<String> geoZones = new ArrayList<String>();
                for (WebElement e : listOfZonesOfCountry) {
                    geoZones.add(e.getAttribute("textContent"));
                }
                boolean sortedGeoZones = Ordering.natural().isOrdered(geoZones);
                System.out.println(sortedGeoZones);
                driver.navigate().back();
            }
            else{ continue;}
        }
        }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }

}
