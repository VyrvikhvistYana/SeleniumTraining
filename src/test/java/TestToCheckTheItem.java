import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestToCheckTheItem {

    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start(){
        System.setProperty("webdriver.chrome.driver", "\\Downloads\\chromedriver.exe");
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, 10);
    }



    @Test
    public void myTest() {
            driver.get("http://localhost/litecart/admin/login.php");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin");
            driver.findElement(By.name("login")).click();
            driver.get("http://localhost/litecart/en/");
            String nameOnTheMainPage= driver.findElement(By.cssSelector("#box-campaigns div ul li a")).getAttribute("title");
            String campaignPrice= driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper strong.campaign-price")).getText();
            String regularPrice=driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper s.regular-price")).getText();

            String regularPriceFontLine=driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper s.regular-price")).getCssValue("text-decoration-line");
            String campaignPriceFont=driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper strong")).getCssValue("font-weight");

            double sizeOfFontOfCampaignPrice=Double.parseDouble(driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper strong.campaign-price")).getCssValue( "font-size").replaceAll("[^0-9\\.]",""));
            double sizeOfFontOfRegularPrice =Double.parseDouble(driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper s.regular-price")).getCssValue("font-size").replaceAll("[^0-9\\.]",""));
            // System.out.println(sizeOfFontOfCampaignPrice);
            //System.out.println(sizeOfFontOfRegularPrice);

            String colorOfRegularPrice=driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper s.regular-price")).getCssValue("color");
            String[] numbers = colorOfRegularPrice.replace("rgba(", "").replace(")", "").split(",");
            int rRP = Integer.parseInt(numbers[0].trim());
            int gRP = Integer.parseInt(numbers[1].trim());
            int bRP = Integer.parseInt(numbers[2].trim());
            //System.out.println( rRP+" "+gRP+" "+bRP);
            if(rRP==gRP && gRP==bRP){
                System.out.println("The color of regular price is gray");
            }
            else{
                System.out.println("The color of regular price is not gray");
            }

            String colorCampaignPrice=driver.findElement(By.cssSelector("div#box-campaigns a.link div.price-wrapper strong.campaign-price")).getCssValue("color");
        String[] numbers1 = colorCampaignPrice.replace("rgba(", "").replace(")", "").split(",");
        int rCP = Integer.parseInt(numbers1[0].trim());
        int gCP = Integer.parseInt(numbers1[1].trim());
        int bCP = Integer.parseInt(numbers1[2].trim());
        //System.out.println( rCP+" "+gCP+" "+bCP);
        if(rCP!=0  && gCP==0 && bCP==0){
            System.out.println("The color of campaign price is red");
        }
        else{
            System.out.println("The color of campaign price is not red");
        }

        if(campaignPriceFont.equals("700")){
            System.out.println("The font of campaign price is bold");
        }
        else{
            System.out.println("The font of campaign price is not bold");
        }

        if(regularPriceFontLine.equals("line-through")){
            System.out.println("The regular price is crossed out");
        }
        else{
            System.out.println("The  regular price is not crossed out");
        }

if(sizeOfFontOfCampaignPrice>sizeOfFontOfRegularPrice){
    System.out.println("Size of font of the campaign price is more than the size of font of the regular price");
}
else{
    System.out.println("Size of font of the campaign price is not more than the size of font of the regular price");
}
            driver.findElement(By.cssSelector("#box-campaigns div ul li a")).click();
            String nameOnThePageOfTheItem=driver.findElement(By.cssSelector("h1.title")).getText();
            String campaignPriceOnThePageOfTheItem=driver.findElement(By.cssSelector("div.information div.price-wrapper strong.campaign-price")).getText();
            String regularPriceOnThePageOfTheItem = driver.findElement(By.cssSelector("div.information div.price-wrapper s.regular-price")).getText();


           if(nameOnTheMainPage.equals(nameOnThePageOfTheItem)){
               System.out.println("The names of the item are the same");
           }
           else {
               System.out.println("The names of the item don't match");}

           if(campaignPrice.equals(campaignPriceOnThePageOfTheItem)){
               System.out.println("Campaign prices match");
           }
           else{
               System.out.println("Campaign prices don't match");
           }

           if(regularPrice.equals(regularPriceOnThePageOfTheItem)){
               System.out.println("Regular prices match");
           }
           else {
               System.out.println("Regular prices don't match");
           }


            //driver.navigate().back();

}
    @After
    public void stop(){
        driver.quit();
        driver=null;
    }
}
