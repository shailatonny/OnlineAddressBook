package net.therap.validator;

import net.therap.command.UserCommand;
import net.therap.domain.User;
import net.therap.service.UserManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("signUpValidator")
public class SignUpValidator implements Validator {
    private static final Logger log = LoggerFactory.getLogger(SignUpValidator.class);
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Autowired
    private UserManager userManager;

    public boolean supports(Class candidate) {
        return UserCommand.class.isAssignableFrom(candidate);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName", "required.login.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "required.full.name");

        UserCommand userCmd = (UserCommand) obj;
        User user = userManager.getUserByLoginName(userCmd.getLoginName());

        if (user != null) {
            errors.rejectValue("loginName", "already.exists.login.name");
        }

        if (!isValidEmail(userCmd.getEmail().trim()))
            errors.rejectValue("email", "incorrect.email");
    }

    private boolean isValidEmail(String input) {
        return input.matches(EMAIL_PATTERN);
    }
}
