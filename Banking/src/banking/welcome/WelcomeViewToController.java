package banking.welcome;

import banking.dto.AccountDetails;

public interface WelcomeViewToController {

    void newUser();

    void attemptToLogin();

    void create();

    void valid(String username);

    void adminControls();

    void invalid();
}