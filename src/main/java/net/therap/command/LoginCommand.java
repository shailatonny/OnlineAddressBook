package net.therap.command;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 12:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginCommand {
    private String loginName;
    private String password;

    public LoginCommand() {
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
