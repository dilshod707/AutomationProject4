import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Airbnb {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com/?has_logged_out=1");

        WebElement login = driver.findElement(By.xpath("//button[@class=\"cnky2vc c1r2bm7w cln384f dir dir-ltr\"]"));
        login.click();
        //Select login = new Select(driver.findElement(By.cssSelector("[data-testid='cypress-headernav-profile']")));
       // login.selectByVisibleText("Log in");
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
    }

}
