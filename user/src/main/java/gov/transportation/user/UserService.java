package gov.transportation.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User registerUser(User user);
    List<User> getUsers();
    void deleteUser(String mail);
    User getUser(String mail);
}
