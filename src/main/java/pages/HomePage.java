
package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By  route = By.cssSelector("a[onclick*='populateSearch(\\'1467469338690\\', \\'Chikkamagaluru\\', \\'1467467616730\\', \\'Bengaluru\\')']");
    private By datePickerInput = By.id("txtJourneyDate");
    private By datePickerLink = By.linkText("25");
    private By searchButton = By.cssSelector("button.btn.btn-primary.btn-lg.btn-block.btn-booking");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickDesiredRoute(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(route));
        element.click();
    }
    public void selectDate(){
        driver.findElement(datePickerInput).click();
        driver.findElement(datePickerLink).click();
    }
    public ResultPage search(){
        WebElement element = driver.findElement(searchButton);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        return new ResultPage(driver);
    }
}
