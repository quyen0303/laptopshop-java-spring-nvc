package vn.phamquyen.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.phamquyen.laptopshop.domain.User;

//crud: create, read, update, delete
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User save(User hoidanit);

    void deleteById(long quyen);

    List<User> findOneByEmail(String email);

    User findOneById(Long id);

    List<User> findAll();
}
