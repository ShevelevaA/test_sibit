package domain.content.account;

import com.codeborne.selenide.Condition;
import domain.elements.HtmlElementWrap;
import domain.elements.WorkStepWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WaitTime;

import static com.codeborne.selenide.Selenide.$;

public class AccountSuccessCreateContent extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(AccountSuccessCreateContent.class);

    public AccountSuccessCreateContent() {
        super($(".content-block").waitUntil(Condition.appear, WaitTime.WAIT_TO_LOAD));
        log.debug("Get AccountSuccessCreateContent [default wait time: " + WaitTime.WAIT_TO_LOAD + "ms.]");
    }

    public String getTitle() {
        log.debug("Return title text");
        return getSelf().find(".page-title").getText();
    }

    public WorkStepWrap getWorkSteps() {
        log.debug("Return work steps");
        return new WorkStepWrap(getSelf().find(".work-steps"));
    }
}
