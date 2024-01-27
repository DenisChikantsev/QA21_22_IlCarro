package tests;

import manager.UserDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.TestBase;

public class LoginTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preConditions() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }

    @Test(dataProvider = "userValidLogin", dataProviderClass = UserDataProvider.class,groups = {"smoke"})
    public void loginSuccess1(User user) {
//        User user = new User().setEmail("marga@gmail.com").setPassword("Mmar123456$");
/*
        User user1 = new User();
        user1.setEmail();
        user.setEmail("marga@gmail.com");
        user.setPassword("Mmar123456$");
*/
        logger.info("Test start with test data --->" + user.toString());
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        //Assert if element with text "Logged in success" is present
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        //app.getHelperUser().clickOKButton();

    }


    @Test(dataProvider = "userWrongEmail", dataProviderClass = UserDataProvider.class)
    public void loginWrongEmail(User  user) {
        logger.info("Test negative check if it possible to login with wrong format email ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test(dataProvider = "userWrongPassword", dataProviderClass = UserDataProvider.class)
    public void loginWrongPassword(User user) {
        logger.info("Test negative check if it possible to login with wrong format password ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }


    @Test(dataProvider = "userUnregistered", dataProviderClass = UserDataProvider.class)
    public void loginWrongUnregisteredUser(User user) {
        logger.info("Test negative check if it possible to login with valid format data unregistered user ");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }


    @AfterMethod(alwaysRun = true)
    public void postConditions() {
        app.getHelperUser().clickOKButton();

    }
}
