package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultPage {
    private WebDriver driver;
    private By boardingPointButton = By.linkText("Boarding Point");
    private By boardingPoint = By.xpath("//li[@id='Forward-1467469338690']");
    private By droppingPointButton = By.linkText("Dropping Point");
    private By droppingPoint =By.xpath("//li[@id='Forward-1467467616730']");
    private By customerDetails = By.xpath("//a[contains(@href, 'Forwardprofile')]");
    private By mobileInput = By.name("mobileNo");
    private By paymentButton = By.id("PgBtn");
    public ResultPage(WebDriver driver){
        this.driver=driver;
    }
    public void selectSeat(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.getElementById('SrvcSelectBtnForward0').click();");
    }
    public void selectBoardingPoint(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(boardingPointButton));
        driver.findElement(boardingPointButton).click();
        driver.findElement(boardingPoint).click();

    }
    public void selectDroppingPoint(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(droppingPointButton));
        driver.findElement(droppingPointButton).click();
        driver.findElement(droppingPoint).click();

    }
    public void setCustomerDetails(String mobileNumber){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(customerDetails));
        driver.findElement(customerDetails).click();
        driver.findElement(mobileInput).sendKeys(mobileNumber);
    }
    public void clickPayment(){
        driver.findElement(paymentButton).click();
    }
}