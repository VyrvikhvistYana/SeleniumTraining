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

        WebElement form = driver.findElement(By.cssSelector("[name=countries_form"));
        WebElement table = form.findElement(By.cssSelector(".dataTable"));
        List<WebElement> links = table.findElements(By.xpath("//tr[@class='row']//td[5]//a"));

        List<String> namesOfCountries = new ArrayList<String>();
        for (WebElement e : links) {
            namesOfCountries.add(e.getAttribute("textContent"));
        }
        boolean sorted = Ordering.natural().isOrdered(namesOfCountries);
        System.out.println(sorted);



        int size=1;
        List<WebElement> rowElements = null;
        for (int i = 0; i < size; ++i) {
            rowElements = driver.findElements(By.xpath("//tr[@class='row']//td[6]"));
            size=rowElements.size();
            if (Integer.parseInt(rowElements.get(i).getAttribute("innerText")) == 0) {
                continue;}
            else{
                links.get(i).click();
                List<WebElement> listOfRows =
                        driver.findElements(By.xpath
                                ("//table[@id='table-zones']//tr//td[3]//input[contains(@type, 'hidden')]"));

                List<String> listOfGeozones = new ArrayList<String>();
                for (WebElement e : listOfRows) {
                    listOfGeozones.add(e.getAttribute("textContent"));
                }
                boolean sortedGeoZones = Ordering.natural().isOrdered(listOfGeozones);
                System.out.println(sortedGeoZones);
                i=rowElements.indexOf(rowElements.get(i));
                size=size-i;
                System.out.println(size);
                System.out.println(i);
                driver.navigate().back();
            }

        }
    }


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }

}
