package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanRequestReceivedPage {

    RemoteWebDriver driver;

    @FindBy(xpath = "//h2[contains(text(),'Thank You')]")
    protected WebElement thankYou;

    @FindBy(xpath = "//h4[contains(text(),'Once we receive all')]")
    protected WebElement notificationMessage;

    public LoanRequestReceivedPage(RemoteWebDriver driver) {
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    @Step("Get main text after submiting loan request")
    public String getThankYouText() {
        return thankYou.getText();
    }

    @Step("Get additional text after submiting loan request")
    public String getNotificationText() {
        return notificationMessage.getText();
    }
}
