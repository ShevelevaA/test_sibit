package domain.elements;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlElementWrap extends ElementsContainer {

    private static final Logger log = LoggerFactory.getLogger(HtmlElementWrap.class);

    private SelenideElement wrappedElement;

    public HtmlElementWrap() {
        super();
    }

    public HtmlElementWrap(SelenideElement root) {
        setSelf(root);
    }

    public SelenideElement getSelf() {
        log.trace("Return self");
        return wrappedElement;
    }

    public void setSelf(SelenideElement wrappedElement) {
        log.trace("Set self");
        this.wrappedElement = wrappedElement;
    }

    public void click() {
        log.trace("Click");
        getSelf().click();
    }
}
