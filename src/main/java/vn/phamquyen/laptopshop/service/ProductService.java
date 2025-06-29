package vn.phamquyen.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.phamquyen.laptopshop.domain.Product;
import vn.phamquyen.laptopshop.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public Product handleSaveProduct(Product product) {
        Product quyendz = this.productRepository.save(product);
        System.out.println(quyendz);
        return quyendz;
    }

    public Product getProductById(long id) {
        Product quyendz = this.productRepository.findById(id);
        return quyendz;
    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }
}
