import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Iframes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.duotech.io/enroll-sqae2");

        WebElement iframe = driver.findElement(By.xpath("//iframe[starts-with( @id,'169')]"));
        driver.switchTo().frame(iframe);

        WebElement firstName = driver.findElement(By.cssSelector("input[placeholder='First']"));
        firstName.sendKeys("Bobby");

        driver.switchTo().defaultContent();//switch the context back to the main page

        //System.out.println(driver.findElement(By.xpath()));


    }

}
