package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NavigationElWrap extends HtmlElementWrap {
    private static final Logger log = LoggerFactory.getLogger(NavigationElWrap.class);

    public NavigationElWrap(SelenideElement root) {
        super(root);
    }

    public String getText() {
        log.trace("Return navigation element text");
        return getSelf().getText();
    }
}
