import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, 5);
    }
    @Test
    public void myTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> listOfLinks = driver.findElements(By.cssSelector("ul.list-vertical li#app-"));
        System.out.println(listOfLinks.size());
        for (int i = 0; i < listOfLinks.size(); i++) {
            listOfLinks = driver.findElements(By.cssSelector("ul.list-vertical li#app-"));
            listOfLinks.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).isDisplayed();
            Boolean listInsideIsPresent=driver.findElements(By.cssSelector("ul.list-vertical li ul.docs li")).size()==0;

           if(listInsideIsPresent==true){
                    continue;
           }
           else {
               listOfLinks = driver.findElements(By.cssSelector("ul.list-vertical li#app-"));
               listOfLinks.get(i).click();
               List<WebElement> listOfLinksInside = driver.findElements(By.cssSelector("ul.list-vertical li#app- ul.docs li"));
               System.out.println(listOfLinksInside.size());
               for (int j = 0; j < listOfLinksInside.size(); j++) {
                     listOfLinksInside = driver.findElements(By.cssSelector("ul.list-vertical li#app- ul.docs li"));
                     listOfLinksInside.get(j).click();
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1"))).isDisplayed();
                     
        }}}}





    @After
    public void stop(){
    driver.quit();
    driver=null;
    }
}
