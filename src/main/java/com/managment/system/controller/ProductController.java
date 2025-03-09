package com.managment.system.controller;

import com.managment.system.entity.Product;
import com.managment.system.serviceImpl.ProductServiceImpl;
import com.managment.system.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createProduct(@RequestBody Product product){
         this.productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> editProduct(@RequestBody Product product){
        this.productService.editProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getProductAll(){
        List<Product> product = this.productService.findAllProduct();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search/id")
    public ResponseEntity<?> getProductById(@RequestParam Integer id){
        Product product = this.productService.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search/name")
    public ResponseEntity<?> getProductsByName(@RequestParam String name){
        List<Product> product = this.productService.findNameProduct(name);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/search/category")
    public ResponseEntity<?> getProductsByCategory(@RequestParam String category){
        List<Product> product = this.productService.findCategoryProduct(category);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
