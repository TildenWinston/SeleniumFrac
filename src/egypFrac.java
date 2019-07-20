//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class egypFrac {
//}
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class egypFrac {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

    public static void main(String[] args)throws Exception{




        File file = new File(".\\input.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        st = br.readLine();
        String platform = br.readLine();

        st = br.readLine();
        String maxLength = br.readLine();
        st = br.readLine();
        String numerator = br.readLine();

        st = br.readLine();
//        while ((st = br.readLine()) != null)
//            System.out.println(st);



        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        if(platform.equals("mac")){
            System.setProperty("webdriver.chrome.driver",".\\chromedriver_mac64\\chromedriver.exe");
        }
        else {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver_win32\\chromedriver.exe");
        }

        WebDriver driver = new ChromeDriver();

    //FirefoxDriver driver = new FirefoxDriver();
        //ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fractions/egyptian.html#section6.1.1");

        WebElement lenSet=driver.findElement(By.xpath("//*[@id=\"ef2len\"]"));
        lenSet.clear();
        lenSet.sendKeys(maxLength);


        WebElement top=driver.findElement(By.xpath("//*[@id=\"ef2top\"]"));
        top.clear();
        top.sendKeys(numerator);

        while((st = br.readLine()) != null) {

            WebElement bottom = driver.findElement(By.xpath("//*[@id=\"ef2bot\"]"));
            bottom.clear();
            bottom.sendKeys(st);

            WebElement button=driver.findElement(By.xpath("/html/body/div[19]/form/div/table/tbody/tr/td[1]/input"));
            button.click();
        }


        WebElement results=driver.findElement(By.xpath("//*[@id=\"msgef2\"]"));
        System.out.println(results.getText());
        System.out.println(System.nanoTime());



        File out = new File("output" + sdf.format(new Timestamp(System.currentTimeMillis())) + ".txt");
        out.createNewFile();

        FileWriter output = new FileWriter(out);
        output.write(results.getText());
        output.flush();
        output.close();


        //*[@id="msgef2"]/text()[1]
    }
}
