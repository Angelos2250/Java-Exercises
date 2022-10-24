package swe4.server.repositories;

import java.util.Map;
import java.util.TreeMap;

public interface UserRepository {

    Map<String,String> findAllUsers();

    String findUserByUsername(final String username);
    void insertUser(String username, String password);

    void deleteUser(String user);
}
