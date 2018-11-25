package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CellWrap extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(CellWrap.class);

    public CellWrap(SelenideElement root) {
        super(root);
    }

    public String getText() {
        log.trace("Return cell's text");
        return getSelf().getText();
    }
}
