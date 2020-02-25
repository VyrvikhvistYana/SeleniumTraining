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

    WebElement mostPopular = driver.findElement(By.cssSelector("#box-most-popular"));
    WebElement ducksInMostPopular=mostPopular.findElement(By.xpath("//ul[@class='listing-wrapper products']"));
    List<WebElement> list = ducksInMostPopular.findElements(By.tagName("li"));
    for (int i=0; i<list.size();i++){
        list.get(i).findElement(By.xpath("//div[contains(@class, 'sticker')]")).isDisplayed();
    }

    WebElement campaigns=driver.findElement(By.cssSelector("#box-campaigns"));
    WebElement ducksInCampaigns = campaigns.findElement((By.xpath("//ul[@class='listing-wrapper products']")));
    List<WebElement> listCampaigns = ducksInCampaigns.findElements((By.tagName("li")));

    for (int i=0; i<list.size(); i++){
        list.get(i).findElement(By.xpath("//div[contains(@class, 'sticker')]")).isDisplayed();}

    WebElement latestProducts=driver.findElement(By.cssSelector("#box-latest-products"));
    WebElement ducksInLatestProducts = latestProducts.findElement((By.xpath("//ul[@class='listing-wrapper products']")));
    List<WebElement> listLatestProducts = ducksInLatestProducts.findElements((By.tagName("li")));
    for (int i=0; i<list.size(); i++){
        list.get(i).findElement(By.xpath("//div[contains(@class, 'sticker')]")).isDisplayed();}
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
