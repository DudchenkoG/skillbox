package Tests;

import Pages.MainPage;
import Pages.SecondPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.open;

public class TestClass {

    Logger LOGGER = Logger.getLogger("test logger");


    @Before
    public void setup_configuration(){
        System.setProperty("webdriver.chrome.driver", Paths.get("chromedriver.exe").toAbsolutePath().toString());
        Configuration.browser = "chrome";
        Configuration.fastSetValue = true;
        Configuration.startMaximized = true;
        LOGGER.info("Test configuration is ready!");

    }

    @Test
    public void first_test(){
        LOGGER.info("Test started!");
        open("https://lm.skillbox.ru/qa_tester/module01/");
        MainPage page = new MainPage();

        Assert.assertTrue("Поле для ввода не существует на странице", page.name_input.exists());
        Assert.assertTrue("Поле для ввода не отображается на странице", page.name_input.isDisplayed());

        Assert.assertTrue("Кнопка подтверждения не существует на странице", page.submit_btn.exists());
        Assert.assertTrue("Кнопка подтверждения не отображается на странице", page.submit_btn.isDisplayed());

        page.name_input.sendKeys("Вася");

        Assert.assertTrue("Кнопка подтверждения не отображается на странице", page.submit_btn.is(Condition.enabled));
        page.submit_btn.click();

        Assert.assertTrue("Текст приветствия не существует на странице", page.hello_text.exists());
        Assert.assertTrue("Текст приветствия не отображается на странице", page.hello_text.isDisplayed());
        Assert.assertTrue("Текст приветствия отличается от ожидаемого. Текст элемента:"+page.hello_text.getText(),
                page.hello_text.is(Condition.exactTextCaseSensitive("Привет, Вася!")));

        LOGGER.info("Test finished!");
    }

    @Test
    public void second_test(){
        LOGGER.info("Test started!");
        SecondPage page = new SecondPage();
        open("http://qa.skillbox.ru/module09/practice4/Kontakty/index.html");

        if (page.first_element.getAttribute("type").equals( "button")){
            LOGGER.info("первый элемент найден");
        }

        if (page.second_element.getAttribute("placeholder").equals("Опишите свои впечатления в нескольких предложениях")){
            LOGGER.info("второй элемент найден");
        }

        if (page.third_element.getAttribute("name").equals("name")){
            LOGGER.info("третий элемент найден");
        }

        if (page.forth_element.getAttribute("placeholder").equals("E-mail")){
            LOGGER.info("четвертый элемент найден");
        }

        if (page.fifth_element.getText().equals("Интересные статьи")){
            LOGGER.info("пятый элемент найден");
        }

        open("http://qa.skillbox.ru/module09/practice4/Catalog/index.html");

        if (page.sixth_element.getAttribute("class").equals("catalog")){
            LOGGER.info("шестой элемент найден");
        }

        if (page.seventh_element.toString().contains("propalyvatel")){
            LOGGER.info("седьмой элемент найден");
        }

        if (page.eighth_element.getAttribute("class").equals("header")){
            LOGGER.info("восьмой элемент найден");
        }

    }




    @After
    public void shut_down(){
        WebDriverRunner.getWebDriver().close();
    }

}
