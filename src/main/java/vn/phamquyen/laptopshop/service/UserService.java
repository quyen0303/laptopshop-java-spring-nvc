package vn.phamquyen.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.phamquyen.laptopshop.domain.User;
import vn.phamquyen.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUserByEmail(String email) {
        return this.userRepository.findOneByEmail(email);
    }

    public User handleSaveUser(User user) {
        User quyen = this.userRepository.save(user);
        System.out.println(quyen);
        return quyen;
    }
}
