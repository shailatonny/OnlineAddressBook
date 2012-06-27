package net.therap.web;

import net.therap.command.LoginCommand;
import net.therap.service.UserManager;
import org.junit.Assert;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;
import org.unitils.mock.Mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/27/12
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class HomeControllerTest extends UnitilsTestNG {

    @TestedObject
    private HomeController homeController;

    @InjectIntoByType
    private Mock<UserManager> userManagerMock;

    @BeforeClass
    public void init() {
    }

    @Test
    public void testLoginForm() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ModelMap model = new ModelMap();

        request.setMethod("GET");

        MockHttpSession session = new MockHttpSession();
        request.setSession(session);

        String view = homeController.showLoginForm(model, request, response);
        Assert.assertEquals(view, "home");
    }
}