package org.launchcode.mealplanner.models.forms;

import javax.validation.constraints.NotNull;

public class RegisterForm extends LoginForm {

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
        checkPasswordMatch();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPasswordMatch();
    }

    private void checkPasswordMatch() {
        if (!getPassword().equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}
