package swe4.server.repositories;

import java.util.Map;
import java.util.TreeMap;

public class FakeUserRepository implements UserRepository{
    public static Map<String,String> users = new TreeMap<>();

    @Override
    public Map<String, String> findAllUsers() {
        return users;
    }

    @Override
    public String findUserByUsername(String username) {
        return users.get(username);
    }

    @Override
    public void insertUser(String username, String password) {
        users.put(username,password);
    }

    @Override
    public void deleteUser(String user) {
        users.remove(user);
    }
}
