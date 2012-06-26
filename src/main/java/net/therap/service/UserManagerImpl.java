package net.therap.service;

import net.therap.command.UserCommand;
import net.therap.dao.UserDao;
import net.therap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 1:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("UserManager")
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    public void saveUser(UserCommand userCmd) {
        User user = new User(userCmd.getLoginName(), userCmd.getPassword(), userCmd.getFullName(), userCmd.getEmail());
        userDao.saveUser(user);
    }

    public User getUserByLoginName(String loginName) {
        return userDao.getUserByLoginName(loginName);
    }

}
