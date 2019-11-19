package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import java.util.regex.*;

public class AuthenticationService {

    private UserDao userDao;
    private Pattern usernameRegex;
    private Pattern passwordRegex;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;

    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.matches("[a-z]{3,}")) {
            if (password.matches("[a-z0-9]{8,}") && password.matches(".*[0-9]+.*")) {
                return false;
            }
        }
        
        return true;
    }
}
