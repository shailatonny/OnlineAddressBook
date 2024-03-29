package net.therap.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("logout.html")
public class LogOutController {
    private static final Logger log = LoggerFactory.getLogger(LogOutController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String logOut(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.invalidate();
        return "redirect:home.html";
    }
}
