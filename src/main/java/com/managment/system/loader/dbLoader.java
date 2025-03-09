package com.managment.system.loader;

import com.managment.system.constants.Constants;
import com.managment.system.entity.Product;
import com.managment.system.entity.User;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dbLoader {

    public dbLoader(){}

    public List<Product> init(){
        List<Product> listProductsToBd = new ArrayList<>();
        listProductsToBd.addAll(getListProductsToBd(getListProducts()));
        listProductsToBd.addAll(getListProductsToBd(getListProducts()));
        listProductsToBd.addAll(getListProductsToBd(getListProducts()));
        listProductsToBd.addAll(getListProductsToBd(getListProducts()));
        return listProductsToBd;
    }

    private List<Map<String, Object>> getListProducts(){
        List<Map<String, Object>> listMap = new ArrayList<>();
        Map<String, Object> map;

        map = new HashMap<>();
        map.put(Constants.NAME, "Pechuga de pavo bajo en sal finas lonchas");
        map.put(Constants.PRICE, 3.50);
        map.put(Constants.QTY, 20);
        map.put(Constants.CATEGORY, "Charcutería y quesos");
        map.put(Constants.WEIGHT, "200g");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Cebolla troceada ultracongelada");
        map.put(Constants.PRICE, 1.99);
        map.put(Constants.QTY, 23);
        map.put(Constants.CATEGORY, "Frutas y verduras");
        map.put(Constants.WEIGHT, "500g");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Semillas de chía");
        map.put(Constants.PRICE, 1.50);
        map.put(Constants.QTY, 50);
        map.put(Constants.CATEGORY, "Cereales y galletas");
        map.put(Constants.WEIGHT, "100g");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Tomates");
        map.put(Constants.PRICE, 3.50);
        map.put(Constants.QTY, 10);
        map.put(Constants.CATEGORY, "Frutas y verduras");
        map.put(Constants.WEIGHT, "3kg");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Multiusos perfumado Bosque Naranja");
        map.put(Constants.PRICE, 1.30);
        map.put(Constants.QTY, 47);
        map.put(Constants.CATEGORY, "Limpieza y Hogar");
        map.put(Constants.WEIGHT, "1L");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Queso Edam");
        map.put(Constants.PRICE, 1.50);
        map.put(Constants.QTY, 22);
        map.put(Constants.CATEGORY, "Charcutería y quesos");
        map.put(Constants.WEIGHT, "200g");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Salsa Teriyaki YUMAKSU");
        map.put(Constants.PRICE, 2.50);
        map.put(Constants.QTY, 75);
        map.put(Constants.CATEGORY, "Salsas asiaticas");
        map.put(Constants.WEIGHT, "500ml");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Huevos L 24U Gallina Campera");
        map.put(Constants.PRICE, 4.50);
        map.put(Constants.QTY, 20);
        map.put(Constants.CATEGORY, "Huevos, leche y Mantequilla");
        map.put(Constants.WEIGHT, "200g");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Paté perro junior Delikiut con ternera y leche");
        map.put(Constants.PRICE, 1.50);
        map.put(Constants.QTY, 22);
        map.put(Constants.CATEGORY, "Mascotas");
        map.put(Constants.WEIGHT, "150g");
        map.put(Constants.IMG, "img/ref");
        listMap.add(map);
        map = new HashMap<>();
        map.put(Constants.NAME, "Pan molde brioche");
        map.put(Constants.PRICE, 2.50);
        map.put(Constants.QTY, 20);
        map.put(Constants.CATEGORY, "Panaderia");
        map.put(Constants.WEIGHT, "500g");
        map.put(Constants.IMG, "img/ref");
        return listMap;
    }

    private List<Product> getListProductsToBd(List<Map<String, Object>> listProductMap){
        List<Product> listReturn = new ArrayList<>();
        int i = 0;

        for(Map<String, Object> product : listProductMap ){
            listReturn.add(getProductMapped(product));
        }
        return listReturn;
    }

    private Product getProductMapped(Map<String, Object> productMap){
        Product product = new Product();
        product.setName(productMap.get(Constants.NAME).toString());
        product.setPrice((Double) productMap.get(Constants.PRICE));
        product.setQty((Integer) productMap.get(Constants.QTY));
        product.setWeight(productMap.get(Constants.WEIGHT).toString());
        product.setCategory(productMap.get(Constants.CATEGORY).toString());
        product.setImg(productMap.get(Constants.IMG).toString());
        product.setUser(getUserForLoad());
        return product;
    }

    private User getUserForLoad(){
        User user = new User();
        user.setId(1);
        return user;
    }

    public User getUserForFirstLoad(){
        User user = new User();
        user.setName("Administrador");
        user.setLast_name("Administrador");
        user.setIs_admin(true);
        return user;
    }
}
