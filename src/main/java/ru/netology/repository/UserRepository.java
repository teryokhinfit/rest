package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Authorities;
import ru.netology.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final ConcurrentHashMap<String, User> repository = new ConcurrentHashMap<>();

    public UserRepository() {
        initRepository();
    }

    private void initRepository() {
        User user1 = new User("Misha", "Misha123", new ArrayList<>(Collections.singleton(Authorities.READ)));
        User user2 = new User("Petya", "Petya123", new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE)));
        User user3 = new User("Vasya", "Vasya123", new ArrayList<>(Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        repository.put(user1.getName(), user1);
        repository.put(user2.getName(), user2);
        repository.put(user3.getName(), user3);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (repository.containsKey(user)) {
            var currentPassword = repository.get(user).getPassword();
            if (password.equals(currentPassword))
                return repository.get(user).getAuthorities();
        }
        return Collections.emptyList();
    }

}

