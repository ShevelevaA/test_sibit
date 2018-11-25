package domain.elements;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TableWrap extends HtmlElementWrap {

    private static final Logger log = LoggerFactory.getLogger(TableWrap.class);

    public TableWrap(SelenideElement root) {
        super(root);
    }


    public RowWrap getRow(int i) {
        log.trace("Return row: " + i);
        return getRows().get(i);
    }

    public List<RowWrap> getRows() {
        log.trace("Create rows and returns.");
        List<RowWrap> list = new ArrayList<RowWrap>();
        for (SelenideElement element : getSelf().findAll(".trng-row-show")) {
            list.add(new RowWrap(element));
        }
        return list;
    }

    public RowWrap getHideRow(int i) {
        log.trace("Return hide row: " + i);
        return getHideRows().get(i);
    }

    public List<RowWrap> getHideRows() {
        log.trace("Create hide rows and returns.");
        List<RowWrap> list = new ArrayList<RowWrap>();
        for (SelenideElement element : getSelf().findAll(".trng-row-hide")) {
            list.add(new RowWrap(element));
        }
        return list;
    }

    public int getRowCount() {
        log.trace("Return row count.");
        return getSelf().findAll(".trng-row-show").size();
    }

    public int getHideRowCount() {
        log.trace("Return row count.");
        return getSelf().findAll(".trng-row-hide").size();
    }

}
