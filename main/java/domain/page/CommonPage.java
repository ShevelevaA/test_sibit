package domain.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import domain.content.account.AccountCreateContent;
import domain.content.account.AccountInfoContent;
import domain.content.account.AccountSuccessCreateContent;
import domain.elements.HtmlElementWrap;
import domain.elements.NavigationElWrap;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WaitTime;

import static com.codeborne.selenide.Selenide.$;

public class CommonPage extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(CommonPage.class);

    public CommonPage() {
        super($(".container-inner").waitUntil(Condition.appear, WaitTime.WAIT_TO_LOAD));
        log.debug("Get AccountCreateContent [default wait time: " + WaitTime.WAIT_TO_LOAD + "ms.]");
    }

    private SelenideElement getNavigation() {
        log.debug("Return main navigation menu");
        return getSelf().find(".nav-list");
    }

    public NavigationElWrap getMyAccountNav() {
        log.debug("Return my accounts navigation element");
        return new NavigationElWrap(getNavigation().find(By.xpath("child::li[3]")));
    }

    public AccountCreateContent getCreateAccountContent() {
        log.debug("Return create account content");
        return new AccountCreateContent();
    }

    public AccountInfoContent getAccountInfoContent() {
        log.debug("Return account info content");
        return new AccountInfoContent();
    }

    public AccountSuccessCreateContent getAccountSuccessCreateContent() {
        log.debug("Return successful create account content");
        return new AccountSuccessCreateContent();
    }

}
