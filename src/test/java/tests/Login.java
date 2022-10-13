package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login extends TastBase {

    @BeforeTest
    public void preCond() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logOut();
        }
    }


    @Test
    public void loginPositive() {

        User user = new User().withEmail("sabant88@mail.ru").withPassword("Miledi88");
        app.getHelperUser().initLogin();
        app.getHelperUser().pause(2000);
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);


        Assert.assertTrue(app.getHelperUser().isLogged());


    }


}
