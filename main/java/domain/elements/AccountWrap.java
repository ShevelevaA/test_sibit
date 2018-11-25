package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountWrap extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(AccountWrap.class);

    public AccountWrap(SelenideElement root) {
        super(root);
    }

    public String getName() {
        log.trace("Return account name");
        return getSelf().find(".check-panel-title").getText();
    }

    public String getgDescription() {
        log.trace("Return account description");
        return getSelf().find(".check-panel-content").getText();
    }

}
