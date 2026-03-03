package utils;

import pages.*;
import pages.elements.SideMenu;

public class App extends BasePage {
   public LoginPage loginPage = new LoginPage();
   public AdminPage adminPage = new AdminPage();
   public UserCredentials userCreds = new UserCredentials();
   public LeavePage leavePage = new LeavePage();
   public PIMPage pimPage = new PIMPage();
   public SideMenu sideMenu = new SideMenu();
}
