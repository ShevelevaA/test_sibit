import domain.content.account.AccountCreateContent;
import domain.content.account.AccountInfoContent;
import domain.content.account.AccountSuccessCreateContent;
import domain.elements.AccountWrap;
import domain.elements.TableWrap;
import domain.elements.WorkStepWrap;
import domain.page.CommonPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.test.ActionBot;
import util.test.UserUtil;

public class AccountsTest extends ConfigurationTest {

    private static final Logger log = LoggerFactory.getLogger(AccountsTest.class);

    private static final String SUCCESS_CREATE_ACCOUNT = "Поздравляем!\nВы открыли торговый счет ";

    @Test
    public void createSeveralAccounts() {
        log.info("~Start test~");
        log.info("Авторизация под пользователем " + UserUtil.TEST_LOGIN);
        ActionBot.login(UserUtil.TEST_LOGIN, UserUtil.TEST_PSW);
        log.info("Получаем страницу добавления счета");
        CommonPage commonPage = new CommonPage();
        AccountCreateContent accountCreateContent = commonPage.getCreateAccountContent();
        log.info("Добавляем счет Mt-5 Market");
        AccountWrap mt5marketAccount = accountCreateContent.getAccountMt5Market();
        String mt5marketName = mt5marketAccount.getName();
        Assert.assertEquals(mt5marketName, "MT5-Market",
                "У выбранного счета отображается название несоответсвующее ожидаемому");
        mt5marketAccount.click();
        accountCreateContent.getAddAccountBtn().click();
        log.info("Проверка данных созданного счета " + mt5marketName);
        AccountSuccessCreateContent accountSuccessCreateContent = commonPage.getAccountSuccessCreateContent();
        Assert.assertEquals(accountSuccessCreateContent.getTitle(), SUCCESS_CREATE_ACCOUNT + mt5marketName,
                "На форме с результатом создания счета отображается неверное наименование созданного счета");
        WorkStepWrap workStepWrap = accountSuccessCreateContent.getWorkSteps();
        Assert.assertNotEquals(workStepWrap.getLogin(), "", "Логин терминала не отображен");
        Assert.assertNotEquals(workStepWrap.getPassword(), "", "Пароль терминала не отображен");
        Assert.assertEquals(workStepWrap.getServerName(), "ForexClub-MT5 Real Server",
                "отображен неверный торговый сервер терминала");
        log.info("Переходим на станицу со счетами клиента");
        commonPage.getMyAccountNav().click();
        AccountInfoContent accountInfoContent = commonPage.getAccountInfoContent();
        TableWrap accountTable = accountInfoContent.getAccountsTable();
        //Уменьшаем количество строк, т.к. в конце таблицы отображается строка - итог
        Assert.assertEquals(accountTable.getRowCount() - 1, 1,
                "В таблице должен отображаться только один счет");
        Assert.assertEquals(accountTable.getRow(0).getCell(0).getText(), "MT5-Market",
                "В таблице отображается неверное наименование счета");
        accountInfoContent.getCreateAccountNav().click();

        log.info("Добавление второго счета");
        accountCreateContent = commonPage.getCreateAccountContent();
        log.info("Добавляем счет Mt-5 Market");
        AccountWrap rumusAccount = accountCreateContent.getAccountRumus();
        String rumusName = rumusAccount.getName();
        Assert.assertEquals(rumusName, "Rumus",
                "У выбранного счета отображается название несоответсвующее ожидаемому");
        rumusAccount.click();
        accountCreateContent.getAddAccountBtn().click();
        log.info("Проверка данных созданного счета " + rumusName);
        accountSuccessCreateContent = commonPage.getAccountSuccessCreateContent();
        accountSuccessCreateContent.getTitle();
        Assert.assertEquals(accountSuccessCreateContent.getTitle(), SUCCESS_CREATE_ACCOUNT + rumusName,
                "На форме с результатом создания счета отображается неверное наименование созданного счета");
        workStepWrap = accountSuccessCreateContent.getWorkSteps();
        Assert.assertNotEquals(workStepWrap.getLogin(), "", "Логин терминала не отображен");
        Assert.assertNotEquals(workStepWrap.getPassword(), "", "Пароль терминала не отображен");
        Assert.assertEquals(workStepWrap.getServerName(), "ForexClub-Classic Real Server",
                "Отображен неверный торговый сервер терминала");
        log.info("Переходим на станицу со счетами клиента");
        commonPage.getMyAccountNav().click();
        accountInfoContent = commonPage.getAccountInfoContent();
        accountTable = accountInfoContent.getAccountsTable();
        //Уменьшаем количество строк, т.к. в конце таблицы отображается строка - итог
        Assert.assertEquals(accountTable.getRowCount() - 1, 2,
                "В таблице должено отображаться два счета");
        //Проверяем отображение счетов в таблице
        if(mt5marketName.equals(accountTable.getRow(0).getCell(0).getText())){
            Assert.assertEquals(accountTable.getRow(1).getCell(0).getText(), rumusName,
                    "В таблице не отображено наименование счета " + rumusName);
        } else {
            if(rumusName.equals(accountTable.getRow(0).getCell(0).getText())){
                Assert.assertEquals(accountTable.getRow(1).getCell(0).getText(), mt5marketName,
                        "В таблице не отображено наименование счета " + mt5marketName);
            }
            else Assert.fail("В таблице отображены счета наименование которых не соотвествует добавленным");
        }

        log.info("~End test~");
    }
}
