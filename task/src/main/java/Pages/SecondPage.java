package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SecondPage {
    public SelenideElement first_element = $x("//*[@value='Отправить']");
    public SelenideElement second_element = $x("//*[@name='comments']");
    public SelenideElement third_element = $("input[placeholder='Имя']");
    public SelenideElement forth_element = $x("//*[@name='email']");
    public SelenideElement fifth_element = $x("//*[@class='menu']/*/*/a[contains(@href, 'Articles')]");
    public SelenideElement sixth_element_maybe = $x("//div[@class='catalog']/..");
    public SelenideElement sixth_element = $x("//div[@class='main-content']/div[@class='catalog']");
    public SelenideElement seventh_element = $x("//div[@class='product-block'][2]");
    public SelenideElement eighth_element = $x("//header[contains(@class,'hea')]");
}
