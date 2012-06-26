package net.therap.web;

import net.therap.command.UserCommand;
import net.therap.service.UserManager;
import net.therap.validator.SignUpValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 12:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SignUpController {
    private static final Logger log = LoggerFactory.getLogger(SignUpController.class);

    @Autowired
    private SignUpValidator signUpValidator;

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "sign-up.html", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        UserCommand userCmd = new UserCommand();
        model.addAttribute("newUser", userCmd);
        return "sign-up";
    }

    @RequestMapping(value = "sign-up.html", method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute("newUser") UserCommand userCmd, BindingResult result, ModelMap model) {

        log.info("in post");
        signUpValidator.validate(userCmd, result);

        if (result.hasErrors()) {
            model.addAttribute("newUser", userCmd);
            return new ModelAndView("sign-up");
        }

        userManager.saveUser(userCmd);
        log.info("after save");
        model.addAttribute("successMsg", "successful");
        return new ModelAndView("redirect:home.html", model);
    }
}
