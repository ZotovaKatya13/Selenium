package utils;

import pages.AdminPage;
import pages.BasePage;
import pages.LeavePage;
import pages.LoginPage;

public class App  extends BasePage {

   public LoginPage loginPage = new LoginPage();
   public AdminPage adminPage = new AdminPage();
   public UserCredentials userCreds = new UserCredentials();
   public LeavePage leavePage = new LeavePage();
}
