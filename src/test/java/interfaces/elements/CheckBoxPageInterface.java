package interfaces.elements;

import org.openqa.selenium.By;

public interface CheckBoxPageInterface {
    By Pash_ALL = By.xpath("//button[@title='Expand all']");
    //By Home = By.xpath("//label[@for='tree-node-home']");
    By Desktop = By.xpath("//label[@for='tree-node-desktop']");
    By Home = By.xpath("//div[@id=\"result\"]");

    By Pash_End = By.xpath("//*[@id=\"tree-node\"]/div/button[2]");
    By Full = By.xpath(" //*[@id=\"tree-node\"]/ol/li/span/label");

}