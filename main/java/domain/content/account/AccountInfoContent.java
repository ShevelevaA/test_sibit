package domain.content.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import domain.elements.HtmlElementWrap;
import domain.elements.NavigationElWrap;
import domain.elements.TableWrap;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WaitTime;

import static com.codeborne.selenide.Selenide.$;

public class AccountInfoContent extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(AccountInfoContent.class);

    public AccountInfoContent() {
        super($(".content").waitUntil(Condition.appear, WaitTime.WAIT_TO_LOAD));
        log.debug("Get AccountInfoContent [default wait time: " + WaitTime.WAIT_TO_LOAD + "ms.]");
    }

    public TableWrap getAccountsTable(){
        log.debug("Return client account table");
        return new TableWrap(getSelf().find(By.xpath("//*[@id=\"account_rests_table_wrapper\"]/div[3]")));
    }
    public TableWrap getBonusTable(){
        log.debug("Return client bonus table");
        return new TableWrap(getSelf().find(By.xpath("//*[@id=\"account_rests_table_wrapper\"]/div[2]")));
    }

    private SelenideElement getSideNavigation(){
        log.debug("Return navigation side menu");
        return getSelf().find(".side-nav");
    }

    public NavigationElWrap getCreateAccountNav(){
        log.debug("Return navigation element at side menu");
        return new NavigationElWrap(getSideNavigation().find(By.xpath("child::li[4]")));
    }

}
