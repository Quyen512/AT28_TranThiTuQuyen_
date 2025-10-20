package interfaces.elements;

import org.openqa.selenium.By;

public interface TextBoxPageInterface {


    //in
    By UserName = By.xpath("//*[@id=\"userName\"]");
    By Email = By.xpath("//*[@id=\"userEmail\"]");
    By Current = By.xpath("(//*[@id=\"currentAddress\"])[1]");
    By PermanentAddress= By.xpath("//*[@id=\"permanentAddress\"]");
    By Submit =By.xpath(" //*[@id=\"submit\"]");

    //out
    By Out = By.xpath(" //*[@id=\"output\"]");
    By Out_Name=By.xpath("//p[@id=\"name\"] ");
    By Out_Email=By.xpath("//p[@id=\"email\"]");
    By Out_Current=By.xpath("//p[@id=\"currentAddress\"]");
    By Out_Permanent=By.xpath("//p[@id=\"permanentAddress\"]");

}
