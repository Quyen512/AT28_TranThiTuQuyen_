package actions.elements;

import actions.common.BasePage;
import interfaces.CommonInterface;
import org.openqa.selenium.WebDriver;

public class MenuLeftAction extends BasePage {
    WebDriver driver;

    public MenuLeftAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenuLeft(String menu){
        highlightElement(driver, CommonInterface.ELEMENTS_MENU, menu);
        clickToElement(driver, CommonInterface.ELEMENTS_MENU, menu);
    }
}
