package vn.phamquyen.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.phamquyen.laptopshop.domain.Cart;
import vn.phamquyen.laptopshop.domain.CartDetail;
import vn.phamquyen.laptopshop.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

    boolean existsByCartAndProduct(Cart cart, Product product);

    CartDetail findCartDetailById(long id);

    CartDetail findByCartAndProduct(Cart cart, Product product);
}
