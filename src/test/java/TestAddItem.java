import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestAddItem {


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
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.findElement(By.xpath("//img[@title='My Store']")).isDisplayed();
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.xpath("//a[contains(text(),' Add New Product')]")).click();
        driver.findElement(By.xpath("//label/input[@value='1']")).click();
        driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys("Duck Yellow");
        driver.findElement(By.xpath("//input[contains(@data-name, 'Rubber Ducks')]")).click();
        driver.findElement(By.xpath("//input[contains(@value, '1-3')]")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("1");
        driver.findElement(By.xpath("//input[contains(@name, 'new_images')]")).sendKeys(new File(".\\src\\test\\java\\duck.jpg").getAbsolutePath());
        driver.findElement(By.name("date_valid_from")).sendKeys("19.01.2020");
        driver.findElement(By.name("date_valid_to")).sendKeys("19.01.2021");

        driver.findElement(By.linkText("Information")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement dropdownManufacturer=driver.findElement(By.name("manufacturer_id"));
        Select selectManufacturer = new Select(dropdownManufacturer);
        selectManufacturer.selectByValue("1");

        driver.findElement(By.xpath("//input[contains(@name, 'short_description')]")).sendKeys("yellow duck");
        driver.findElement(By.xpath("//input[contains(@name, 'head_title')]")).sendKeys("yellow duck");
        driver.findElement(By.xpath("//input[contains(@name, 'meta_description')]")).sendKeys("duck");

        driver.findElement(By.linkText("Prices")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("100");
        WebElement dropdownCurrency=driver.findElement(By.name("purchase_price_currency_code"));
        Select selectCurrency = new Select(dropdownCurrency);
        selectCurrency.selectByValue("USD");
        driver.findElement(By.xpath("//input[contains(@name, 'prices')]")).sendKeys("100");
        driver.findElement(By.name("save")).click();

        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.linkText("Duck Yellow")).isDisplayed();
    }

    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
