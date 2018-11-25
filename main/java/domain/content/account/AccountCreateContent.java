package domain.content.account;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import domain.elements.AccountWrap;
import domain.elements.ButtonWrap;
import domain.elements.HtmlElementWrap;
import domain.elements.TextFieldWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WaitTime;

import static com.codeborne.selenide.Selenide.$;

public class AccountCreateContent extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(AccountCreateContent.class);

    public AccountCreateContent() {
        super($(".account-type").waitUntil(Condition.appear, WaitTime.WAIT_TO_LOAD));
        log.debug("Get AccountCreateContent [default wait time: " + WaitTime.WAIT_TO_LOAD + "ms.]");
    }

    private SelenideElement getAccountsArea() {
        log.debug("Return element accounts area");
        return getSelf().find(".account-type-list");
    }

    private AccountWrap findAccount(String tradesystemid) {
        log.debug("Search account");
        for (SelenideElement account :
                getAccountsArea().findAll(".account-type-form")) {
            if (account.getAttribute("tradesystemid").equals(tradesystemid))
                return new AccountWrap(account);
        }
        log.error("Cannot find account by tradesystemid = " + tradesystemid);
        return null;
    }

    public AccountWrap getAccountRumus() {
        log.debug("Return account wrap Rumus account");
        return findAccount("2");
    }

    public AccountWrap getAccountMt5Market() {
        log.debug("Return account wrap Mt-5 Market account");
        return findAccount("12");
    }

    public TextFieldWrap getSerialNumber() {
        log.debug("Return text field serial number");
        return new TextFieldWrap(getSelf().find("#sn1"));
    }

    public TextFieldWrap getAccessCode() {
        log.debug("Return text field access code");
        return new TextFieldWrap(getSelf().find("#pc1"));
    }

    public ButtonWrap getAddAccountBtn() {
        log.debug("Return button add account ");
        return new ButtonWrap(getSelf().find(".btn-xl"));
    }
}
