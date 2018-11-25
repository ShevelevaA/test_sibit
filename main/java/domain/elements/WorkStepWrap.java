package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkStepWrap extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(WorkStepWrap.class);

    public WorkStepWrap(SelenideElement root) {
        super(root);
    }

    private SelenideElement getPersonalData() {
        log.trace("Return personal data element");
        return getSelf().find(".login-personal-data");
    }

    public String getLogin() {
        log.trace("Return login value");
        return getPersonalData().find(".user-id").getText();
    }

    public String getPassword() {
        log.trace("Return password value");
        return getPersonalData().find(".password").getText();
    }

    public String getServerName() {
        log.trace("Return server name value");
        return getPersonalData().find(".server-name").getText();
    }
}
