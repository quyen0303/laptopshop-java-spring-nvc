package vn.phamquyen.laptopshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.phamquyen.laptopshop.domain.Cart;
import vn.phamquyen.laptopshop.domain.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUser(User user);

    void deleteById(long id);

    Cart save(Cart cart);

    List<Cart> findAll();
}
