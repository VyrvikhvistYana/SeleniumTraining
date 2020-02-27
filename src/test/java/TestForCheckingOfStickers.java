import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestForCheckingOfStickers {
    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, 10);
    }
    @Test
    public void myTest(){
    driver.get("http://localhost/litecart/en/");

    WebElement boxMostPopular = driver.findElement(By.cssSelector("div#box-most-popular ul"));
    List<WebElement> listPopular = boxMostPopular.findElements(By.tagName("li"));
    for (int i=0; i<listPopular.size();i++){
        Boolean isOneSticker=listPopular.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size()==1;
        System.out.println(isOneSticker);
    }


   WebElement campaigns=driver.findElement(By.cssSelector("div#box-campaigns ul"));
   List<WebElement> listDucksInCampaigns = campaigns.findElements(By.tagName("li"));
   for(int i=0; i<listDucksInCampaigns.size();i++){
       Boolean isOneSticker=listDucksInCampaigns.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size()==1;
       System.out.println(isOneSticker);
   }

   WebElement latestProducts=driver.findElement(By.cssSelector("div#box-latest-products ul"));
   List<WebElement> listLatestProducts = latestProducts.findElements(By.tagName("li"));
   for(int i=0; i<listLatestProducts.size();i++){
       Boolean isOneSticker=listLatestProducts.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size()==1;
       System.out.println(isOneSticker);
        }
   }


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
