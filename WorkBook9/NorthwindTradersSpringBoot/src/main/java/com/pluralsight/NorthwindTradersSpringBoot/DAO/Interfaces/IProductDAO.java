package com.pluralsight.NorthwindTradersSpringBoot.DAO.Interfaces;

import com.pluralsight.NorthwindTradersSpringBoot.DAO.models.Product;

import java.util.List;

public interface IProductDAO
{
    Product insert(Product product);

    List<Product> getAll();
}
