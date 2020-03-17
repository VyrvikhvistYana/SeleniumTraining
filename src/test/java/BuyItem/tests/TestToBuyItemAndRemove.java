package BuyItem.tests;

import BuyItem.pages.ProductPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestToBuyItemAndRemove {
 private ProductPage productPage;
 private WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost/litecart/en/");
    }

    @Test
    public void testBuyItemAndRemove(){
        productPage=new ProductPage(driver);
        productPage.addItemToCart();
        productPage.removeItemsFromCart();
        }


    @After
    public void tearDown(){
    driver.quit();
    }}


