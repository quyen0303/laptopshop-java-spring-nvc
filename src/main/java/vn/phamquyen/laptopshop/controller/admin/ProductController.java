package vn.phamquyen.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import vn.phamquyen.laptopshop.domain.Product;
import vn.phamquyen.laptopshop.service.ProductService;
import vn.phamquyen.laptopshop.service.UploadService;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;
    

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> products = this.productService.fetchProducts();
        model.addAttribute("products", products);
        return "admin/product/show";
    }

    @RequestMapping("/admin/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
        System.out.println("Check path id = " + id);
        Product product = this.productService.fetchProductById(id).get();
        System.out.println("Product: " + product);
        model.addAttribute("product", product);
        return "admin/product/detail";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String createProductPage(Model model,
            @ModelAttribute("newProduct") @Valid Product hoidanit,
            BindingResult newProductBindingResult,
            @RequestParam("quyendzFile") MultipartFile file) {
        // System.out.println(" run here " + hoidanit);

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }
        // validate
        if (newProductBindingResult.hasErrors()) {
            return "/admin/product/create";
        }
        System.out.println(file);
        String image = this.uploadService.handleSaveUploadFile(file, "product");
        hoidanit.setImage(image);
        // hoidanit.setRole(this.userService.getRoleByName(hoidanit.getRole().getName()));
        //save
        this.productService.createProduct(hoidanit);
        return "redirect:/admin/product";//chuyen huong trang
    }

    @RequestMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable long id) {
        Product currentProduct = this.productService.fetchProductById(id).get();
        model.addAttribute("newProduct", currentProduct);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProductPage(Model model, @ModelAttribute("newProduct") @Valid Product updatedProduct,
            BindingResult newProductBindingResult,
            @RequestParam("quyendzFile") MultipartFile file) {

        if (newProductBindingResult.hasErrors()) {
            return "admin/product/update";
        }
        Product currentProduct = this.productService.fetchProductById(updatedProduct.getId()).get();
        if (currentProduct != null) {
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentProduct.setImage(img);
            }
            currentProduct.setName(updatedProduct.getName());
            currentProduct.setDetailDesc(updatedProduct.getDetailDesc());
            currentProduct.setShortDesc(updatedProduct.getShortDesc());
            currentProduct.setQuantity(updatedProduct.getQuantity());
            currentProduct.setSold(updatedProduct.getSold());
            currentProduct.setFactory(updatedProduct.getFactory());
            currentProduct.setTarget(updatedProduct.getTarget());

            this.productService.createProduct(currentProduct);
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteProductPage(Model model, @PathVariable long id) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProductPage(Model model, @ModelAttribute("newProduct") Product deleleProduct) {
        this.productService.deleteProduct(deleleProduct.getId());
        return "redirect:/admin/product";
    }  

}
