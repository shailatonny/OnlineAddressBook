package net.therap.validator;

import net.therap.command.LoginCommand;
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
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Component("loginValidator")
public class LoginValidator implements Validator {
    private static final Logger log = LoggerFactory.getLogger(LoginValidator.class);

    @Autowired
    private UserManager userManager;

    public boolean supports(Class candidate) {
        return LoginCommand.class.isAssignableFrom(candidate);
    }

    public void validate(Object obj, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginName", "required.login.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");

        LoginCommand loginCmd = (LoginCommand) obj;

        User user2 = userManager.getUserByLoginName(loginCmd.getLoginName());

        if (user2 == null) {
            errors.rejectValue("loginName", "incorrect.login.name");
        } else if (!loginCmd.getPassword().equals(user2.getPassword())) {
            errors.rejectValue("password", "incorrect.password");
        }
    }
}
