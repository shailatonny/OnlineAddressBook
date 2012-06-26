package net.therap.dao;

import net.therap.domain.User;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: shaila
 * Date: 6/26/12
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserDao extends HibernateDaoSupport {
    public static final Logger log = LoggerFactory.getLogger(UserDao.class);

    public void saveUser(User user) {
        log.info("in saveUser");
        Session session = getSession();
        session.save(user);
        session.flush();
        //throw new RuntimeException();
    }

    public User getUserByLoginName(String loginName) {
        String query = "FROM User user WHERE user.loginName = :login_name";
        List<User> userList = this.getHibernateTemplate().findByNamedParam(query, "login_name", loginName);
        return (userList.size() == 0) ? null : userList.get(0);
    }
}
