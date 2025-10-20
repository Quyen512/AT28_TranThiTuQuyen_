package interfaces;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  interface HomePageInterface {
    String Home_url = "https://demoqa.com/";

    By Elements = By.xpath("//h5[text()='Elements']/ancestor::div[contains(@class,'top-card')]");
    By Forms = By.xpath("//h5[text()='Forms']/ancestor::div[contains(@class,'top-card')]");
    By Alerts_Frame_Windows = By.xpath("//h5[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'top-card')]");
    By Widgets = By.xpath("//h5[text()='Widgets']/ancestor::div[contains(@class,'top-card')]");
    By Interactions = By.xpath("//h5[text()='Interactions']/ancestor::div[contains(@class,'top-card')]");
    By BookStore_Application = By.xpath("//h5[text()='Book Store Application']/ancestor::div[contains(@class,'top-card')]");
}