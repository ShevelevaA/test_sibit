package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RowWrap extends HtmlElementWrap {
    private static final Logger log = LoggerFactory.getLogger(RowWrap.class);

    public RowWrap(SelenideElement root) {
        super(root);
    }

    public void click() {
        log.trace("Click by row");
        getSelf().click();
    }

    public CellWrap getCell(int i) {
        log.trace("Return cell number: " + i);
        return getCells().get(i);
    }

    public List<CellWrap> getCells() {
        List<CellWrap> list = new ArrayList<CellWrap>();
        for (SelenideElement element : getSelf().findAll(".trng-tcell")) {
            list.add(new CellWrap(element));
        }
        log.trace("Return cells");
        return list;
    }
}
