import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

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
    driver.findElement(By.cssSelector("ul#box-apps-menu [id=app-]")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.cssSelector("#doc-logotype")).click();
    driver.findElement(By.linkText("Catalog")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Product Groups")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Option Groups")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Manufacturers")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Suppliers")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Delivery Statuses")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Sold Out Statuses")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Quantity Units")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("CSV Import/Export")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Countries")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Currencies")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Customers")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("CSV Import/Export")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Newsletter")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Geo Zones")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Languages")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Storage Encoding")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Modules")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Orders")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.cssSelector(".docs [id=doc-order_statuses]")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Pages")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Reports")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.cssSelector(".docs [id=doc-monthly_sales]")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.cssSelector(".docs [id=doc-most_sold_products]")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.cssSelector(".docs [id=doc-most_shopping_customers]")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Settings")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Store Info")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Defaults")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("General")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Listings")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Images")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Checkout")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Advanced")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Security")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Slides")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Tax")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Tax Rates")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Translations")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Search Translations")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Scan Files")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("CSV Import/Export")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("Users")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();
    driver.findElement(By.linkText("vQmods")).click();
    driver.findElement(By.cssSelector("h1")).isDisplayed();}


    @After
    public void stop(){
    driver.quit();
    driver=null;
    }
}
