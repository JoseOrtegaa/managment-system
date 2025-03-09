package com.managment.system.serviceImpl;

import com.managment.system.dtos.ProductDTO;
import com.managment.system.entity.Product;
import com.managment.system.loader.dbLoader;
import com.managment.system.entity.User;
import com.managment.system.repository.ProductRepository;
import com.managment.system.repository.UserRepository;
import com.managment.system.service.ProductService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {
    Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


 /*   @Override
    public Product createProduct(Product product) {
        User user = this.userRepository.findById(product.getUser().getId()).orElseThrow(() -> new RuntimeException("User not Found"));

        if(!user.getIs_admin()){
            throw new RuntimeException("No tienes suficientes permisos");
        }

        return productRepository.save(product);
    }*/

    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product editProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product findProduct(int id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Boolean existProduct(int id) {
        return this.productRepository.existsById(id);
    }

    @Override
    public void deleteProduct(int id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public List<Product> findNameProduct(String condition) {
        return this.productRepository.findByNameContainingIgnoreCase(condition);
    }

    @Override
    public List<Product> findCategoryProduct(String condition) {
        return this.productRepository.findByCategoryContainingIgnoreCase(condition);
    }

    @Override
    public Long countProduct() {
        return this.productRepository.count();
    }

    @PostConstruct
    private void init(){
        if(this.productRepository.count() < 51){
            dbLoader loader = new dbLoader();
            List<Product> listProducts = loader.init();
            User user = loader.getUserForFirstLoad();

            this.userRepository.save(user);
            LOGGER.info(" ·······> USER CREATED <······· ");
            this.productRepository.saveAll(listProducts);
            LOGGER.info(" ·······> PRODUCTS CREATED <······· ");
        } else {
            LOGGER.info(" ·······> LIMIT OF PRODUCTS LOADER <······· ");
        }

    }
}
