package BuyItem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage  {

    public WebDriver driver;
    public WebDriverWait wait;


    public ProductPage(WebDriver driver) {
        this.driver=driver;
        wait=new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);
    }



    @FindBy(css=".product")
    private List<WebElement> products;

    @FindBy(xpath="//select[@name='options[Size]']")
    private List<WebElement> productSize;

    @FindBy(xpath="//button[@value='Add To Cart']")
    private WebElement buttonAdd;

    @FindBy(css="span.quantity")
    public  WebElement numberOfProducts;

    @FindBy(linkText ="Checkout »")
    public static WebElement linkToNavigateToCart;

    @FindBy(css="td.item")
    public List<WebElement>  productInTheCart;

    @FindBy(name="remove_cart_item")
    public static WebElement buttonToRemoveItemsFromTheCart;

    @FindBy(xpath ="//select[@required='required']")
    public static WebElement select;


    public void addItemToCart(){

    for (int i=0; i<3; i++){
        products.get(0).click();
        if(productSize.size()==0){
           wait.until(ExpectedConditions.visibilityOf(buttonAdd)).click();
           wait.until(ExpectedConditions.textToBePresentInElement(numberOfProducts, Integer.toString(i+1)));
        }

        else{WebElement dropdownSizeOfDuck=select;
        dropdownSizeOfDuck.click();
        Select selectSize = new Select(dropdownSizeOfDuck);
        selectSize.selectByValue("Small");
        buttonAdd.click();
        wait.until(ExpectedConditions.textToBePresentInElement(numberOfProducts, Integer.toString(i+1)));
        }
        driver.navigate().back();
        }}
        public void removeItemsFromCart(){
            linkToNavigateToCart.click();
            for(int i=0;i<productInTheCart.size(); i++){
                wait.until(ExpectedConditions.visibilityOf(buttonToRemoveItemsFromTheCart)).click();
                wait.until(ExpectedConditions.stalenessOf(productInTheCart.get(i)));
            }
        }


}
