package interfaces.elements;

import org.openqa.selenium.By;
public interface RadioButton {
    // Radio button hiển thị
    By YES = By.xpath("//*[@id='yesRadio']");
    By IMPRESSIVE = By.xpath("//*[@id='impressiveRadio']");

    // Input thực tế (ẩn)
    By YES_INPUT = By.id("yesRadio");
    By IMPRESSIVE_INPUT = By.id("impressiveRadio");

    // Kết quả hiển thị sau khi chọn
    By RESULT_VALUE = By.xpath("//span[@class='text-success']");
}