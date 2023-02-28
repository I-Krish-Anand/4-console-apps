package banking.welcome;

import banking.Repository.Bank;


public class WelcomeModel implements WelcomeModelToController {
    WelcomeControllerToModel welcomeController;

    WelcomeModel(WelcomeController welcomeController) {
        this.welcomeController = welcomeController;
    }

    @Override
    public void verifycredentials(String username, String password) {

       int choice= Bank.getInstance().verifyCredentials(username,password);
       if(choice==1)
           welcomeController.adminControls();
       if(choice==2)
           welcomeController.valid(username);
       else
           welcomeController.invalid();
    }

}