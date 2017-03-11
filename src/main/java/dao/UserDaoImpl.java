package dao;

import dao.interfaces.UserDao;
import entity.User;

/**
 * Реализация NoteDAO
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao<User, String> {

    public UserDaoImpl() {
    }

    public void persist(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findUserByLogin(String login) {
        return em.find(User.class, login);
    }

}
