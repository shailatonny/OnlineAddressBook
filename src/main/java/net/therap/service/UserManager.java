package net.therap.service;

import net.therap.command.UserCommand;
import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */

public interface UserManager {
    public void saveUser(UserCommand userCmd);
    public User getUserByLoginName(String loginName);
}
