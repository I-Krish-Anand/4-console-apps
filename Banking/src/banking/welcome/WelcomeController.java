package banking.welcome;

public class WelcomeController implements WelcomeControllerToView, WelcomeControllerToModel {
    private final WelcomeViewToController welcomeView;
    private final WelcomeModelToController welcomeModel;

    WelcomeController(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        welcomeModel = new WelcomeModel(this);
    }

    @Override
    public void checkUserChoice(int choice) {
        switch (choice) {
            case 1 -> welcomeView.newUser();
            case 2 -> welcomeView.attemptToLogin();
            default -> {
                System.out.println("Invalid Choice, Enter again");
                welcomeView.create();
            }
        }
    }

    @Override
    public void verifycredentials(String username, String password) {
        welcomeModel.verifycredentials(username,password);
    }

    @Override
    public void valid(String username) {
        welcomeView.valid(username);
    }

    @Override
    public void adminControls() {
        welcomeView.adminControls();
    }

    @Override
    public void invalid() {
        welcomeView.invalid();
    }
}