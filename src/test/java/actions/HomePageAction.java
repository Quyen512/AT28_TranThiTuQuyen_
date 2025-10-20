package actions;

import actions.common.BasePage;
import interfaces.CommonInterface;
import interfaces.HomePageInterface;
import org.openqa.selenium.WebDriver;

public class HomePageAction extends BasePage {
    WebDriver driver;

    public HomePageAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenu(String menu) {
        scrollIntoView(driver, CommonInterface.HOME_PAGE_MENU, menu);
        highlightElement(driver, CommonInterface.HOME_PAGE_MENU, menu);
        SleepInSeconds(3);
        clickToElement(driver, CommonInterface.HOME_PAGE_MENU, menu);
    }

}
