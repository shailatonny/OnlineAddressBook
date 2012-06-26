package net.therap.web;

import net.therap.command.LoginCommand;
import net.therap.domain.User;
import net.therap.service.UserManager;
import net.therap.validator.LoginValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("home.html")
public class HomeController {
    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserManager userManager;

    @Autowired
    private LoginValidator loginValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String showLoginForm(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String successMsg = ServletRequestUtils.getStringParameter(request, "successMsg", null);
        if (successMsg != null)
            model.addAttribute("msg", "You have successfully registered!");
        LoginCommand loginCmd = new LoginCommand();
        model.addAttribute("loginForm", loginCmd);
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processLoginForm(@ModelAttribute("loginForm") LoginCommand loginCmd, BindingResult result,
                              ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        loginValidator.validate(loginCmd, result);

        if (result.hasErrors()) {
            model.addAttribute("loginForm", loginCmd);
            return "home";
        }

        User user = userManager.getUserByLoginName(loginCmd.getLoginName());

        HttpSession session = request.getSession();
        session.setAttribute("User", user);

        return "redirect:profile.html";
    }
}