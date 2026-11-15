package Service;

import Entity.Product;
import Repository.ProductRepository;

import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Cache individual product
    @Cacheable(value = "productById", key = "#id")
    public Product getProduct(Long id) {

        System.out.println("Fetching product from DATABASE");

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    // Cache complete product list
    @Cacheable(value = "products", key = "'all'")
    public List<Product> getAllProducts() {

        System.out.println("Fetching products from DATABASE");

        return productRepository.findAll();
    }

    // Save product and clear product list cache
    @CacheEvict(value = "products", key = "'all'")
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    // Update product and remove old cached values
    @Caching(evict = {
            @CacheEvict(value = "productById", key = "#id"),
            @CacheEvict(value = "products", allEntries = true)
    })
    public Product updateProduct(Long id, Product updatedProduct) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        existing.setName(updatedProduct.getName());
        existing.setCategory(updatedProduct.getCategory());
        existing.setPrice(updatedProduct.getPrice());

        return productRepository.save(existing);
    }

    // Delete product and clear related caches
    @Caching(evict = {
            @CacheEvict(value = "productById", key = "#id"),
            @CacheEvict(value = "products", allEntries = true)
    })
    public void deleteProduct(Long id) {

        productRepository.deleteById(id);
    }
}
