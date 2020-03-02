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

import java.util.List;

public class TestToBuyItem {
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

        for (int i=0; i<3; i++){
            List<WebElement> products=driver.findElements(By.cssSelector(".product"));
            wait.until(ExpectedConditions.visibilityOfAllElements(products));
            products.get(0).click();

            boolean isElementNotPresent=driver.findElements(By.xpath("//select[@name='options[Size]']")).size()==0;
            if(isElementNotPresent==true){
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add_cart_product"))).click();
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.quantity"),Integer.toString(i+1)));
            }
            else{WebElement dropdownSizeOfDuck=driver.findElement(By.xpath("//select[@name='options[Size]']"));
                dropdownSizeOfDuck.click();
                Select selectSize = new Select(dropdownSizeOfDuck);
                selectSize.selectByValue("Small");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add_cart_product"))).click();
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.quantity"),Integer.toString(i+1)));

            }

            System.out.println("The number of added items in the cart is "+driver.findElement(By.cssSelector("span.quantity")).getAttribute("innerText"));
            driver.navigate().back();
        }
        driver.findElement(By.linkText("Checkout »")).click();
        List<WebElement> productsInTheCart=driver.findElements(By.cssSelector("td.item"));
        for(int i=0;i<productsInTheCart.size(); i++){
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("remove_cart_item"))).click();
            wait.until(ExpectedConditions.stalenessOf(productsInTheCart.get(i)));
        }}
        @After
    public void stop(){
        driver.quit();
        driver=null;
    }

}
