package com.anonymous.welcome;
import com.anonymous.repository.Repository;

public class WelcomeModel implements WelcomeModelToController {
    WelcomeControllerToModel welcomeController;

    WelcomeModel(WelcomeController welcomeController) {
        this.welcomeController = welcomeController;
    }

    @Override
    public void verifycredentials(String username, String password) {
       boolean flag= Repository.getInstance().verifyCredentials(username,password);
       if(flag)
           valid(username);
       else
           inValid();
    }

    @Override
    public void guestLogin(String username, String question) {
        if( Repository.getInstance().guestLogin(username,question))
            welcomeController.questionSentSuccessfully();
        else
            welcomeController.invalidUsername();
    }

    private void valid(String username){
         welcomeController.valid(username);
    }
    private void inValid(){
        welcomeController.invalid();
    }
}