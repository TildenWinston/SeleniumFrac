//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class test2 {
//}
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;


public class test2 {
    public static void main(String[] args){

        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        System.setProperty("webdriver.chrome.driver",".\\chromedriver_win32\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver",".\\chromedriver_mac64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        //FirefoxDriver driver = new FirefoxDriver();
        //ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fractions/egyptian.html#section6.1.1");
        WebElement top=driver.findElement(By.xpath("//*[@id=\"ef2top\"]"));
        top.sendKeys("4");

        WebElement bottom=driver.findElement(By.xpath("//*[@id=\"ef2bot\"]"));
        bottom.sendKeys("7");

        WebElement button=driver.findElement(By.xpath("/html/body/div[19]/form/div/table/tbody/tr/td[1]/input"));
        button.click();


        driver.get("http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fractions/egyptian.html#section6.1.1");
        WebElement top1=driver.findElement(By.xpath("//*[@id=\"ef2top\"]"));
        top1.sendKeys("4");

        WebElement bottom1=driver.findElement(By.xpath("//*[@id=\"ef2bot\"]"));
        bottom1.sendKeys("7");

        WebElement button1=driver.findElement(By.xpath("/html/body/div[19]/form/div/table/tbody/tr/td[1]/input"));
        button1.click();

        WebElement results=driver.findElement(By.xpath("//*[@id=\"msgef2\"]"));
        System.out.println(results.getText());

        //*[@id="msgef2"]/text()[1]
    }
}
