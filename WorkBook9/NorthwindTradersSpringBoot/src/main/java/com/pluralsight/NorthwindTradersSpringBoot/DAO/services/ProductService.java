package com.pluralsight.NorthwindTradersSpringBoot.DAO.services;

import com.pluralsight.NorthwindTradersSpringBoot.DAO.Interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersSpringBoot.DAO.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService
{
    private final IProductDAO productDao;

    @Autowired
    public ProductService(IProductDAO productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(Product product) {
        return productDao.insert(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

}
