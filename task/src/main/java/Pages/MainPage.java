package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement name_input = $x("//*[@name = 'name']");
    public SelenideElement submit_btn = $x("//*[@class='custom-form__button button']");
    public SelenideElement hello_text = $x("//*[@class='start-screen__res container']");
}
