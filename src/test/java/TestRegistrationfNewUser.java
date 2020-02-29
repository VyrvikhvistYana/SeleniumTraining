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

import java.util.Random;

public class TestRegistrationfNewUser {

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
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("New customers click here"))).click();
    WebElement dropdownCountry=driver.findElement(By.cssSelector(".select2-hidden-accessible"));
    Select select = new Select(dropdownCountry);
    select.selectByValue("US");


    driver.findElement(By.name("postcode")).sendKeys("12000");

    Random random= new Random();
    int n=random.nextInt(1000)+1;
    String email="vyrvikhvist"+ n+"@mail.ru";


    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).clear();
    String password="12345678";
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("confirmed_password")).sendKeys(password);
    driver.findElement(By.name("phone")).clear();
    driver.findElement(By.name("phone")).sendKeys("+79038276028");
    driver.findElement(By.name("firstname")).sendKeys("John");
    driver.findElement(By.name("lastname")).sendKeys("Smith");
    driver.findElement(By.name("city")).sendKeys("New York");
    driver.findElement(By.name("address1")).sendKeys("Street Main 23");
    driver.findElement(By.name("create_account")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(email);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.name("login")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout"))).click();

}


    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
