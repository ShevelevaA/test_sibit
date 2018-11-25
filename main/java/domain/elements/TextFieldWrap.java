package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextFieldWrap extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(TextFieldWrap.class);

    public TextFieldWrap(SelenideElement root) {
        super(root);
    }

    public void clear() {
        log.trace("Clear text field");
        getSelf().clear();
    }

    public String getText() {
        log.trace("Return text");
        return getSelf().val();
    }

    public void setText(String text) {
        log.trace("Set text");
        getSelf().setValue(text);
    }
}
