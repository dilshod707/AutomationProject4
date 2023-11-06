import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //Alert 1: Basic Alert
        //driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.accept();

        //Alert 2: Confirm Alert
//        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
//        Thread.sleep(2000);
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();// clicking cancel

        //Alert 3: Prompt Alert
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("NewList");// print
        System.out.println(alert.getText());
        alert.accept();



        driver.findElement(By.linkText("Elemental Selenium")).click();


    }
}
