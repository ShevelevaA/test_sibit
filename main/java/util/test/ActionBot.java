package util.test;

import domain.page.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionBot {

    private static final Logger log = LoggerFactory.getLogger(ActionBot.class);

    public static void login(String login, String password) {
        log.info("Login. User " + login + ", password '" + password + "'");
        LoginPage loginForm = new LoginPage();
        loginForm.getEmail().setText(login);
        loginForm.getPassword().setText(password);
        loginForm.getCode().setText(""); //FIXME неизвесто как обойти проверку на бота
        loginForm.getLoginBtn().click();
    }

}
