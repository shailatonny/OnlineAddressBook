package net.therap.web;

import net.therap.domain.User;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ProfileController {
    public static final Logger log = LoggerFactory.getLogger(ProfileController.class);

    @RequestMapping(value = "profile.html", method = RequestMethod.GET)
    public String showProfile(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("User");
        model.addAttribute("loginName", user.getLoginName());
        model.addAttribute("userId", user.getUserId());
        return "profile";
    }
}
