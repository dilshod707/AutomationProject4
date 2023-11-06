import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Airbnb {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com/?has_logged_out=1");

        Thread.sleep(4000);
        WebElement login = driver.findElement(By.xpath("//button[@class='cnky2vc c1r2bm7w cln384f dir dir-ltr']"));
        login.click();
        Thread.sleep(2000);

        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();
        Thread.sleep(3000);


        driver.findElement(By.xpath("//button[@data-testid='social-auth-button-email']")).click();
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.xpath("//input[@id=\"email-login-email\"]"));
        userName.sendKeys("dilshod.u.b@gmail.com", Keys.ENTER);
        Thread.sleep(5000);

        WebElement password = driver.findElement(By.xpath("//input[@data-testid='email-signup-password']"));
        password.sendKeys("Salom@2024", Keys.ENTER);
        Thread.sleep(3000);

        WebElement profileIcon = driver.findElement(By.xpath("//img[@elementtiming=\"LCP-target\"][@aria-hidden=\"true\"][1]"));
        Assert.assertTrue(profileIcon.isDisplayed());
        Thread.sleep(3000);

        WebElement addGuest = driver.findElement(By.xpath("//div[@class=\"f16sug5q f1m1t62k dir dir-ltr\"]"));

        addGuest.click();
        Thread.sleep(3000);

        WebElement addAdult = driver.findElement(By.xpath("//button[@data-testid='stepper-adults-increase-button']"));
        addAdult.click();
        Thread.sleep(1000);
        addAdult.click();

        WebElement addKids = driver.findElement(By.xpath("//button[@data-testid='stepper-children-increase-button']"));
        addKids.click();
        addKids.click();
        Thread.sleep(1000);


        WebElement destination = driver.findElement(By.id("bigsearch-query-location-input"));
        destination.sendKeys("Ibiza, Spain");
        Thread.sleep(2000);

        WebElement addDates = driver.findElement(By.xpath("//div[@data-testid='structured-search-input-field-split-dates-0']"));
        addDates.click();
        Thread.sleep(2000);

        WebElement november6 = driver.findElement(By.xpath("//div[@data-testid='calendar-day-11/06/2023']"));
        november6.click();
        Thread.sleep(2000);

        WebElement november12 = driver.findElement(By.xpath(" //div[@data-testid='calendar-day-11/12/2023']"));
        november12.click();
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.xpath("//button[@data-testid='structured-search-input-search-button']"));
        search.click();
        Thread.sleep(2000);

        WebElement filter = driver.findElement(By.xpath("//button[@data-testid='category-bar-filter-button']"));
        filter.click();
        Thread.sleep(8000);

        WebElement minPrice = driver.findElement(By.id("price_filter_min"));
        Thread.sleep(2000);
        minPrice.sendKeys(Keys.COMMAND + "a", Keys.DELETE);
        Thread.sleep(2000);
        minPrice.sendKeys("100");
        Thread.sleep(1000);

        WebElement maxPrice = driver.findElement(By.xpath("//input[@id='price_filter_max']"));
        maxPrice.sendKeys(Keys.COMMAND + "a", Keys.DELETE);
        Thread.sleep(1000);
        maxPrice.sendKeys("600");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='l1ovpqvx bmx2gr4 c1ih3c6 dir dir-ltr']")).click();

        Thread.sleep(2000);

        List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class='_1y74zjx'] |//span[@class='_tyxjp1']"));
        List<Integer> prices = new ArrayList<>();

        for (WebElement i : searchResults) {
            prices.add(Integer.parseInt(i.getText().replace("$", "").replace(" ", "")));
        }

        for (Integer price : prices) {
            Assert.assertTrue(price >= 100 && price <= 600);
        }
        Thread.sleep(2000);
        String pricePerNight = searchResults.get(0).getText();
        String total = driver.findElement(By.xpath("(//div[@class='_tt122m']//span)[1]")).getText().replace(" total", "");
        System.out.println(total);
        String rating = driver.findElement(By.xpath("//span[@class='r1dxllyb dir dir-ltr']")).getText().substring(0, 3);

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='cy5jw6o  dir dir-ltr'][1]")).click();
        String mainWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@aria-label='Close']")).click();

        String priceToCompare = driver.findElement(By.xpath("(//span[@class='_1y74zjx'])[2]")).getText();
        Assert.assertEquals(pricePerNight, priceToCompare);
        String ratingToCompare = driver.findElement(By.xpath("//span[@class='_1uaq0z1l']")).getText().substring(0, 3);
        Assert.assertEquals(rating, ratingToCompare);
        String totalPrice = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", driver.findElement(By.xpath("//span[@class='_1qs94rc']//span[@class='_j1kt73']")));

        Thread.sleep(2000);
        System.out.println(totalPrice);
        Assert.assertEquals(total, totalPrice);
        driver.close();
        driver.switchTo().window(mainWindowHandle);

        Thread.sleep(2000);
        WebElement profile = driver.findElement(By.xpath("//button[@data-testid='cypress-headernav-profile']"));
        profile.click();

        Thread.sleep(4000);
        WebElement logout = driver.findElement(By.linkText("Log out"));
        logout.click();


        driver.quit();

    }


}


