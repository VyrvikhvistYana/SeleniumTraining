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

    List<WebElement> products=driver.findElements(By.cssSelector(".product"));
        for (int i=0; i<products.size();i++){
            Boolean isOneSticker=products.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]")).size()==1;
            System.out.println(isOneSticker);
        }


       }
   


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
