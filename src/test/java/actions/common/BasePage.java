package actions.common;

import common.GlobalVariables;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * BasePage - Class cơ sở cho toàn bộ Page Object
 * Chứa toàn bộ hàm xử lý Locator, Element, Actions, Alert, Frame, Dropdown, Tab...
 */
public class BasePage {

    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor js;

    public By getXpath(String xpath) {
        return By.xpath(xpath);
    }

    public By getDynamicXpath(String pattern, String... params) {
        return By.xpath(String.format(pattern, (Object[]) params));
    }

    public WebElement getElement(WebDriver driver, String xpath) {
        return driver.findElement(getXpath(xpath));
    }

    public List<WebElement> getElements(WebDriver driver, String xpath) {
        return driver.findElements(getXpath(xpath));
    }

    public List<WebElement> getElements(WebDriver driver, String xpath, String... params) {
        return driver.findElements(getDynamicXpath(xpath, params));
    }

    public String getDynamicLocator(String pattern, String... params) {
        return String.format(pattern, (Object[]) params);
    }

    public WebElement getDynamicElement(WebDriver driver, String xpath, String... params) {
        return driver.findElement(getDynamicXpath(xpath, params));
    }

    public void clickToElement(WebDriver driver, String xpath) {
        waitForElementClickable(driver, xpath);
        getElement(driver, xpath).click();
    }

    public void clickToElement(WebDriver driver, String xpath, String... params) {
        waitForElementClickable(driver, xpath, params);
        getDynamicElement(driver, xpath, params).click();
    }

    public void enterTextToElement(WebDriver driver, String xpath, String value) {
        waitForElementIsVisible(driver, xpath);
        getElement(driver, xpath).clear();
        getElement(driver, xpath).sendKeys(value);
    }

    public void enterTextToElement(WebDriver driver, String xpath, String value, String... params) {
        waitForElementIsVisible(driver, xpath, params);
        getDynamicElement(driver, xpath, params).clear();
        getDynamicElement(driver, xpath, params).sendKeys(value);
    }

    public void enterTextToElementUsingActions(WebDriver driver, String xpath, String value) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        getElement(driver, xpath).clear();
        actions.sendKeys(getElement(driver, xpath), value).perform();
    }

    public void enterTextToElementUsingActions(WebDriver driver, String xpath, String value, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath, params);
        getDynamicElement(driver, xpath, params).clear();
        actions.sendKeys(getDynamicElement(driver, xpath, params), value).perform();
    }

    public void clickToElementByJS(WebDriver driver, String xpath) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, xpath));
    }

    public void clickToElementByJS(WebDriver driver, String xpath, String... params) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getDynamicElement(driver, xpath, params));
    }
    
    public void waitForElementIsVisible(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(getElement(driver, xpath)));
    }

    public void waitForElementIsVisible(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(getDynamicElement(driver, xpath, params)));
    }

    public void waitForElementClickable(WebDriver driver, String xpath) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(getElement(driver, xpath)));
    }

    public void waitForElementClickable(WebDriver driver, String xpath, String... params) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(getDynamicElement(driver, xpath, params)));
    }

    public void highlightElement(WebDriver driver, String xpath) {
        waitForElementIsVisible(driver, xpath);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getElement(driver, xpath));
    }

    public void highlightElement(WebDriver driver, String xpath, String... params) {
        waitForElementIsVisible(driver, xpath, params);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", getDynamicElement(driver, xpath, params));
    }

    public void SleepInSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {}
    }

    public void hoverOverElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath);
        actions.moveToElement(getElement(driver, xpath)).perform();
    }

    public void hoverOverElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        waitForElementIsVisible(driver, xpath, params);
        actions.moveToElement(getDynamicElement(driver, xpath, params)).perform();
    }

    public void rightClickOnElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        actions.contextClick(getElement(driver, xpath)).perform();
    }

    public void rightClickOnElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        actions.contextClick(getDynamicElement(driver, xpath, params)).perform();
    }

    public void doubleClickOnElement(WebDriver driver, String xpath) {
        actions = new Actions(driver);
        actions.doubleClick(getElement(driver, xpath)).perform();
    }

    public void doubleClickOnElement(WebDriver driver, String xpath, String... params) {
        actions = new Actions(driver);
        actions.doubleClick(getDynamicElement(driver, xpath, params)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceXpath, String targetXpath) {
        actions = new Actions(driver);
        actions.dragAndDrop(getElement(driver, sourceXpath), getElement(driver, targetXpath)).perform();
    }

    public void pressKeyToElement(WebDriver driver, String xpath, Keys key) {
        getElement(driver, xpath).sendKeys(key);
    }

    public void pressKeyToElement(WebDriver driver, String xpath, Keys key, String... params) {
        getDynamicElement(driver, xpath, params).sendKeys(key);
    }

    public String getTextElement(WebDriver driver, String xpath) {
        waitForElementIsVisible(driver, xpath);
        return getElement(driver, xpath).getText().trim();
    }

    public String getTextElement(WebDriver driver, String xpath, String... params) {
        waitForElementIsVisible(driver, xpath, params);
        return getDynamicElement(driver, xpath, params).getText().trim();
    }

    public String getElementAttributeValue(WebDriver driver, String xpath, String attributeName) {
        return getElement(driver, xpath).getAttribute(attributeName);
    }

    public String getElementAttributeValue(WebDriver driver, String xpath, String attributeName, String... params) {
        return getDynamicElement(driver, xpath, params).getAttribute(attributeName);
    }

    public int getListElementSize(WebDriver driver, String xpath) {
        return getElements(driver, xpath).size();
    }

    public int getListElementSize(WebDriver driver, String xpath, String... params) {
        return getElements(driver, xpath, params).size();
    }

    public boolean isDisplayElement(WebDriver driver, String xpath) {
        return getElement(driver, xpath).isDisplayed();
    }

    public boolean isDisplayElement(WebDriver driver, String xpath, String... params) {
        return getDynamicElement(driver, xpath, params).isDisplayed();
    }

    public boolean isDisplayElements(WebDriver driver, String xpath) {
        List<WebElement> elements = getElements(driver, xpath);
        return !elements.isEmpty() && elements.stream().allMatch(WebElement::isDisplayed);
    }

    public boolean isDisplayElements(WebDriver driver, String xpath, String... params) {
        List<WebElement> elements = getElements(driver, xpath, params);
        return !elements.isEmpty() && elements.stream().allMatch(WebElement::isDisplayed);
    }

    public void getPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void waitForAlertPresence(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariables.SHORT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void enterTextToAlert(WebDriver driver, String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void switchWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchWindowByTitle(WebDriver driver, String expectedTitle) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            driver.switchTo().window(id);
            if (driver.getTitle().equals(expectedTitle)) break;
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String id : allWindows) {
            if (!id.equals(parentID)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String xpath, String itemText) {
        new Select(getElement(driver, xpath)).selectByVisibleText(itemText);
    }

    public void selectItemInDefaultDropdown(WebDriver driver, String xpath, String itemText, String... params) {
        new Select(getDynamicElement(driver, xpath, params)).selectByVisibleText(itemText);
    }

    public String getFirstSelectedTextItem(WebDriver driver, String xpath) {
        return new Select(getElement(driver, xpath)).getFirstSelectedOption().getText();
    }

    public String getFirstSelectedTextItem(WebDriver driver, String xpath, String... params) {
        return new Select(getDynamicElement(driver, xpath, params)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpath) {
        return new Select(getElement(driver, xpath)).isMultiple();
    }

    public boolean isDropdownMultiple(WebDriver driver, String xpath, String... params) {
        return new Select(getDynamicElement(driver, xpath, params)).isMultiple();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String xpath) {
        WebElement element = getElement(driver, xpath);
        if (!element.isSelected()) element.click();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String xpath, String... params) {
        WebElement element = getDynamicElement(driver, xpath, params);
        if (!element.isSelected()) element.click();
    }

    public void unCheckToCheckbox(WebDriver driver, String xpath) {
        WebElement element = getElement(driver, xpath);
        if (element.isSelected()) element.click();
    }

    public void unCheckToCheckbox(WebDriver driver, String xpath, String... params) {
        WebElement element = getDynamicElement(driver, xpath, params);
        if (element.isSelected()) element.click();
    }

    public void setImplicitTime(WebDriver driver, long timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public void switchToFrame(WebDriver driver, String xpath) {
        driver.switchTo().frame(getElement(driver, xpath));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void scrollIntoView(WebDriver driver, String xpath, String... params) {
        WebElement el = getDynamicElement(driver, xpath, params);
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block:'center', inline:'center'});", el);
        } catch (JavascriptException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
        }
    }
}
