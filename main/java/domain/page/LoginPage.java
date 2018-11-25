package domain.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import domain.elements.ButtonWrap;
import domain.elements.HtmlElementWrap;
import domain.elements.TextFieldWrap;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WaitTime;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage() {
        super($(".authorization").waitUntil(Condition.appear, WaitTime.WAIT_TO_LOAD));
        log.debug("Get LoginPage [default wait time: " + WaitTime.WAIT_TO_LOAD + "ms.]");
    }

    private SelenideElement getLoginBox() {
        log.debug("Return login box");
        return getSelf().find(".authorization__login-box");
    }

    public TextFieldWrap getEmail() {
        log.debug("Return login text field");
        return new TextFieldWrap(getLoginBox().find("#email-2"));
    }

    public TextFieldWrap getPassword() {
        log.debug("Return password text field");
        return new TextFieldWrap(getLoginBox().find("#password"));
    }

    public TextFieldWrap getCode() {
        log.debug("Return code text field");
        return new TextFieldWrap(getLoginBox().find(By.name("j_captcha_response_input")));
    }

    public ButtonWrap getLoginBtn() {
        log.debug("Return login button");
        return new ButtonWrap(getLoginBox().find("#btnLogin"));
    }

    public ButtonWrap getCheckInBtn() {
        log.debug("Return registration button");
        return new ButtonWrap(getLoginBox().find(".btn-orange"));
    }
}
