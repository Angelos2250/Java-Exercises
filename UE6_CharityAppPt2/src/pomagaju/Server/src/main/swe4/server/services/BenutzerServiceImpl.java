package swe4.server.services;

import swe4.server.repositories.RepositoryFactory;
import swe4.server.repositories.UserRepository;

import java.util.Map;

public class BenutzerServiceImpl implements BenutzerService {
    private final UserRepository userRepository = RepositoryFactory.userRepositoryInstance();
    @Override
    public Map<String, String> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public String findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void insertUser(String username, String password) {
        userRepository.insertUser(username,password);
    }

    @Override
    public void deleteUser(String user) {
        userRepository.deleteUser(user);
    }

    @Override
    public boolean containsKey(String key) {
        return userRepository.findAllUsers().containsKey(key);
    }

    @Override
    public boolean containsValue(String val) {
        return userRepository.findAllUsers().containsValue(val);
    }
}
