package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ButtonWrap extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(ButtonWrap.class);

    public ButtonWrap(SelenideElement root) {
        super(root);
    }

    public String getText() {
        log.trace("Return text of element");
        return getSelf().find(".v-button-caption").getText();
    }

}
