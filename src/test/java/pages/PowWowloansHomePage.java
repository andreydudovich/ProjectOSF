package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PowWowloansHomePage {

    WebDriver driver;

    protected final String APPLY_NOW = "action_button";
    protected final String HOME_PAGE = "https://powwowloans.co.za/";

    //class name
    @FindBy(className = APPLY_NOW)
    protected WebElement applyNow;

    public PowWowloansHomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create  all WebElements
        PageFactory.initElements(driver, this);
    }

    @Step("Open https://powwowloans.co.za/ page")
    public PowWowloansHomePage open(){
        driver.get(HOME_PAGE);
        return this;
    }

    @Step("Click Apply Now button")
    public void clickApplyNow() {
        applyNow.click();
    }
}
