package com.managment.system.service;

import com.managment.system.dtos.ProductDTO;
import com.managment.system.entity.Product;
import java.util.List;

public interface ProductService {
    public Product createProduct(Product product);
    public Product editProduct(Product product);
    public Product findProduct(int id);
    public Boolean existProduct(int id);
    public void deleteProduct(int id);
    public List<Product> findAllProduct();
    public List<Product> findNameProduct(String condition);
    public List<Product> findCategoryProduct(String condition);
    public Long countProduct();
}
